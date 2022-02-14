# MVCC
### 说明
MVCC 的英文全称是 Multiversion Concurrency Control ，中文意思是多版本并发控制
也可理解为：一致性非锁定读，即mysql基于自己的回滚机制为并发场景下的读操作做的读取优化。

### 实现mvcc基础

- undo log版本链
  - 每条数据都有两个隐藏字段trx_id和roll_pointer
  - trx_id
    1. 最近一次更新这条数据的事务id
  - roll_pointer
    1. 指向更新这个事务之前生成的undo log
    2. 多个事务串行执行时，每个事务修改一行数据，就会更新隐藏的trx_id和roll_pointer
    3. 同时之前多个数据快照对应的undo log，会通过roll_pointer指针串联起来，形成版本链
- ReadView机制
  - 执行事务的时候，就会生成一个ReadView，包含四个比较重要的字段
  - m_ids
    1. 此时有哪些事务在Mysql里执行还没有提交的
  - min_trx_id
    1. m_ids里最小的值
  - max_trx_id
    1. mysql下一个要生成的事务id，就是最大事务id
  - creator_trx_id
    1. 当前事务的id
  - 可能情况
    1. 判断查询的数据的trx_id是否小于当前事务ReadView中的min_trx_id，如果小于ReadView里的min_trx_id，说明该事务开启之前，修改这行数据的事务已经提交了，所以可以查到这行数据
    2. 如果trx_id大于当前事务ReadView里的min_trx_id，同时小于ReadView里面的max_trx_id，说明更新这条数据的事务是和当前事务是在同一时刻开启的，然后看看该数据的trx_id是否在ReadView的m_ids列表里面。如果在ReadView的m_ids列表里面，说明这个修改数据的事务和当前事务同一时间段并发执行然后提交的，这行数据不能查询。然后就顺着这条数据的roll_pointer顺着undo log日志链条往下找，找到最近的一条undo log，如果找到trx_id小于ReadView里的min_trx_id,说明这个undo log版本必然是当前事务开启之间就执行并且提交的。那么就查询这个undo log里的值。
    3. 如果是当前事务更新了这条数据的值，发现trx_id和自己的ReadView里的creator_trx_id是一样的。说明数据是自己修改的，当然可以查看使用。
    
### MVCC实现RC

#### 基于ReadView机制实现Read Committed RC
 - 当一个事务被设置为Read Committed时，这个事务每次发起查询，都会重新生成一个ReadView 
   
 - 流程
   1. 有一条数据是事务id为50的事务插入的
   2. 现在活跃的事务有有A、B两个事务，A事务的id 为60，B事务的id为70
   3. 此时B事务对这条数据执行了update操作，这条数据的trx_id变成了70，同时会生成一个undo log，由roll_pointer来指向。
   4. 然后A事务对这条数据进行查询，会生成一个ReadView，此时ReadView里min_trx_id = 60,max_trx_id=71,creator_trx_id=60
   4. 发现此时数据的trx_id为70，属于ReadView事务id范围之内，说明在A事务生成ReadView之前就活跃的事务，是这个事务修改了数据，但是这个事务还没提交，所以再ReadView的m_ids里有两个数据[60,70],根据ReadView的机制，此时事务A不能查看事务B修改的值。
   4. 然后顺着undo log版本链往下查找，就会找到一个原始的值，发现它的trx_id为50，小于事务A当前ReadView里的min_trx_id,说明在他生成ReadView前，就有一个事务插入了这个值，并且提交。因此可以查到该值。
   4. 然后事务B进行了提交。提交以后，事务B就不再活跃。此时事务A再去查询该数据时，就能查询到B事务提交数据。
   4. 事务A再去查询该数据时，会重新生成一个ReadView，此时ReadView里min_trx_id=60,max_trx_id=71,creator_trx_id=60,但m_ids为[60]
   4. 事务A基于这个新的ReadView再去查询该数据时候，发现这条数据trx_id为70，虽然在min_trx_id和max_trx_id之间，但是并没有在m_ids之间，说明事务b在本次ReadView之前就已经提交了，就能够查询到事务B提交的值

### MVCC实现RR

#### 基于ReadView机制实现 Repeatable Read RR
  - 当一个事务被设置为Repeatable Read时候，这个事务每次发起查询时，只会查询trx_id小于自己ReadView提交的数据，或者查询自己提交修改的数据。
  - 实现不可重复读的流程
    1. 有一条数据是事务id为50的事务插入的
    1. 现在活跃的事务有有A、B两个事务，A事务的id 为60，B事务的id为70
    1. 此时B事务对这条数据执行了update操作，并且提交，这条数据的trx_id变成了70，同时会生成一个undo log，由roll_pointer来指向。
    1. 然后A事务对这条数据进行查询，会生成一个ReadView，此时ReadView里min_trx_id = 60,max_trx_id=71,creator_trx_id=60
    1. 发现此时数据的trx_id为70，属于ReadView事务id范围之内，说明在A事务生成ReadView之前就活跃的事务，是这个事务修改了数据，但是这个事务还没提交，所以再ReadView的m_ids里有两个数据[60,70],根据ReadView的机制，此时事务A不能查看事务B修改的值。
    1. 然后顺着undo log版本链往下查找，就会找到一个原始的值，发现它的trx_id为50，小于事务A当前ReadView里的min_trx_id,说明在他生成ReadView前，就有一个事务插入了这个值，并且提交。因此可以查到该值。 
       
  - 实现避免幻读流程
    1. 事务A事先用select * from x where id >10查询，可能查询到一条数据，而且读到的就是原始数据的版本
    1. 现在有个事务C插入了一条数据并且也提交了，事务C的id为80
    1. 然后事务A再使用select * from x where id >10查询，此时会有两条数据，一条是以前那条，一条是事务C插入的一条数据
    1. 这条数据的trx_80，大于事务A的ReadView的max_trx_id,说明事务A发起查询之后，事务C才启动，所以这条数据不能查询。还是只能查询一条数据。
