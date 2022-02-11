# explain字段解释

mysql通过explain命令，可以对select语句的执行计划进行分析

### 示例数据库脚本
```sql
-- 用户表
create table tuser(
	id int PRIMARY key,
	loginname varchar(100),
	name varchar(100),
	age int,
	sex char(1),
	dep int,
	address varchar(100)
);
-- 部门表
create table tdep(
id int PRIMARY key,
name varchar(100)
)
-- 地址表
create  table taddr(
id int PRIMARY key,
addr varchar(100)
)
-- 创建普通索引
alter table tuser add index idx_dep(dep);
-- 创建唯一索引
alter table tuser add unique index idx_loginname(loginname);
-- 创建组合索引
alter table tuser add index idx_name_age_sex(name,age,sex);
-- 创建全文索引
alter table taddr add fulltext ft_addr(addr);

```


### 字段解释
- id列
  - 每个select语句都会自动分配的一个唯一标识符,union 的结果id为null
  - 表示查询中操作表的顺序有三种情况：
    1. id相同：执行顺序由上到下
    2. id不同：如果是子查询，id号会增加，id越大，优先级越高
    3. id相同的不同的同时存在
- select_type列
  - 查询类型，主要区别普通查询、联合查询（union、union all）、子查询等
  - simple
    - 表示不需要union操作或者不包含子查询的简单select查询。有连接查询时，外层的查询为simple，且只有一个。
    ```sql
    explain select * from tuser;
    ```
  - primary
    - 一个需要union操作或者含有子查询的select，位于最外层的单位查询的select_type即为primary。且只要一个。
    ```sql
    explain select (select name from tuser) from tuser;
    ```
    
  - subquery
    - 除了from字句中包含的子查询外，其他地方出现的子查询都可能是subquery
    ```sql
    explain select * from tuser where id = (select max(id) from tuser)
    ```
    
  - dependent subquery
    - 与dependent union 类似，表示这个subquery的查询要受到外部表查询的影响
    ```sql
    explain select id,name,(select name from tdep a where a.id = b.id) from user b;
    ```
    
  - union
    - union连接的两个select查询，第一个查询时PRIMARY，除了第一个表外，第二个以后的表select_type 都是union
    ```sql
    explain select * from tuser where sex = '1' union select * from tuser where sex = '2'
    ```
    
  - dependent union
    - 与union一样，出现在union或union all语句中，但是这个查询要受到外部查询的影响
    ```sql
    explain select * from user where sex in (select sex from user where sex= '1' union select sex from user where sex ='2')
    ```
    
  - union result
    - 包含union的结果集，在union和union all语句中，因为它不需要参与查询，所以id字段为null
    ```sql
    select sex from user where sex= '1' union select sex from user where sex ='2'
    ```
    
  - derived
    - from字句中出现的子查询，也叫派生表，其他数据库中可能叫做内联视图或者嵌套select
    - 普通的查询from语句在子查询中并不会为derived，还是为simple
    ```sql
    explain  select * from (select * from user where sex = '1') b;
    ```
    - 带有union或者jion的子查询才会为derived
    ```sql
    explain  select * from (select sex from user where sex= '1' union select sex from user where sex ='2') b;
    ```

- table列
  - 显示的查询表名，如果查询使用了别名，那么这里显示的是别名
  - 如果不涉及对数据表的操作，那么这显示为null 
  - 如果显示为尖括号括起来的就表示这个是临时表，后面的N就是执行计划中的id，表示结果来自于这个查询产生
  - 如果是尖括号括起来的<union M,N>，也类似，也是一个临时表，表示这个结果来自于union查询的id为M，N的结果集
    
- type列
  - 表示关联类型，即Mysql决定如何查找表中的行
  - ALL  
    - 全表扫描，mysql必须扫描整张表，从头到尾，去找到需要的行。
    - 这个就是全表扫描数据文件，然后再在server层进行过滤返回符合要求的记录。  
    - 例外：如果在查询里使用了LIMIT，或者Extra显示 Using distinct/not exists
        ```sql
        explain select * from tuser;
        ```
    
  - index 
    - 和全表扫描一样，只是mysql扫描表时按索引次序进行而不是行
    - 索引全表扫描，把索引从头到尾扫一遍，常见于使用索引列就可以处理不需要读取数据文件的查询、可以使用索引排序或者分组的查询
    - 关键字：条件是出现在索引树中的节点。可能没有完全匹配索引。
    - 优点：避免了排序
    - 缺点：要承担按索引次序读取整个表的开销。若是随机次序访问行，开销会更大
    - 如果Extra列有 using index,说明mysql正在使用覆盖索引。
    - 单索引
      ```sql
      explain select loginname from tuser;
      ```
    - 组合索引
      ```sql
      explain select age from tuser;
      ```
    - 覆盖索引
        ```sql
        explain select  name,age from tuser;
        ```
  - range
    - 范围扫描就是一个有限制的索引扫描，它开始于索引里的某一个点，返回匹配这个值域的行。
    - 比全索引扫描好，不用遍历全部索引。
    - 当带有Between、where条件带有>的查询、in()或or列表就会显示范围扫描
    - 此类扫描的开销跟索引类型相当
    - '>,<,is null'
      ```sql
      explain select name from tdep where id >100;
      ```
        - like 前缀索引
          ```sql
          explain select name from tdep where name like 'a%';
          ```
        - 注意：like '%z' 不使用索引 
         ```sql
        explain select name from tdep where name like '%a'; 
        ```
          
  - ref  
    - 返回所有匹配某个单个值的行。
    - 可能会找到多个符合条件的行，是查找和扫描的混合
    - 此类索引访问只有使用非唯一性索引或者唯一索引的非唯一性前缀才会发生，或者是使用了最左前缀规则索引的查询。
    - 非唯一索引
        ```sql
        explain select * from tuser where dep =1;
        ```
    - 等值非主键连接（需要连接的字段都创建了索引，如果不创建索引非ref）
        ```sql
        create index idx_name on tdep (name);
        EXPLAIN select  a.id from tuser a left join tdep b on a.name = b.name;
        ```
    - 最左前缀
      ```sql
      explain select * from tuser where name ='a'
      ```
  - ref_or_null
    - 是ref的一个变体，意味着mysql必须在初次查询的结果里进行第二次查找找出null条目
    
  - eq_ref
    - 这种索引查找，mysql知道最多只返回一条符合条件的记录。
    - 这种访问方式可以在mysql使用主键或者唯一性索引查找时看到，它会将它与某个参考值比较
    - 性能非常好
    - 此类型通常出现在多表的join查询，表示对于前表的每一个结果，都只能匹配到后表的一行结果。并且查询的比较操作符是‘=’，查询效率较高
    ```sql
    explain select a.id from tuser a left join tdep b on a.dep = b.id；
    ```
    
  - const
    - mysql能怼查询的某部分进行优化并转换成一个常量时，就会使用这类访问类型。
    ```sql
    explain select * from tuser where id =1    
    ```
  
  - fulltext
    - 全文索引检索，要注意，全文索引的优先级很高，若全文索引和普通索引同时存在，mysql不管代价，优先选择使用全文索引
    ```sql
    explain select * from taddr where match(addr) against('a');
    ```
   
  - system 
    - 表中只有一行数据或者是空表
      
  - null
    - 这种访问方式意味着mysql能在优化阶段分解查询语句，在执行阶段升值用不着在访问表或者索引
  
- possible_keys列
  - 此次查询中可能选用的索引，一个或多个
    
- key列
  - 查询真正使用到的索引，select_type为index_merge时，这里可能出现两个以上的索引，其他select_type这里只会出现一个
    
- key_len列
  - 用于处理查询的索引长度，如果是单列索引，那就整个索引长度算进去，如果是多列索引，那么查询不一定都能使用到所有的列，具体使用到了多少个列的索引，这里就会计算进去，没有使用到的列，就不会计算
  - 留意下这列的值，算一下你的多列索引总长度就知道有没有使用到所有的列了
  - 另外，key_len只计算where条件用到的索引长度，而排序和分组就算用到了索引，也不会计算到key_len中。
    
- ref列
  - 如果是使用的常数等值查询，这里会显示const
  - 如果是连接查询，被驱动表的执行计划这里会显示查询的关联字段
  - 如果是条件使用了表达式或者函数，或者条件列发生了内部隐式转换，这里可能显示为func
    
- rows列
  这里是执行计划中估算的扫描行数，不是精确值（InnoDB不是精确值，MyISAM是精确值，主要原因是InnoDB里面使用了MVCC并发机制）
  
- filtered列
  使用explain extened时会出现这个列，5.7之后的版本默认就有这个字段，不需要使用explain extendedle
  这个字段表示存储引擎返回的数据在server层过滤后，剩下多少满足查询的记录数量比例，注意是百分比，不是具体记录数。