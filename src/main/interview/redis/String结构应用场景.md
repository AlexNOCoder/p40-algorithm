# String结构应用场景

### 说明

- 单值缓存
  - SET key value
  - GET key

- 对象缓存
  - SET user:1 value(json格式数据)
  - MSET user:1:name zhuge user:1:balance 1888
  - MGEGET user:1:name user:1:balance

- 分布式锁
  - SETNX product:10001 true    // 返回1代表获取锁成功
  - SETNX product:10001 true    // 返回0代表获取锁失败
  - 执行业务操作
  - DEL product:10001       // 执行完业务释放锁
  - SET product:10001 true ex 10 nx   // 防止程序以外终止导致死锁

注意：1.过期时间设置为10秒，可能因为服务器宕机卡住，超过十秒，导致其他线程拿到过期后的锁，并使得锁失效，可以将一个uuid加锁以后，在删除的时候判断是不是自己加的锁
2.最好将设置为10秒过期的锁，然后再配后一个后台线程，每个小于10秒的定时任务去扫描锁，并给正在执行的锁续期

- 计数器
  - INCR article:readcount:{文章id}
  - GET article:readcount:{文章id}

- 分布式系统全局序列号
  - INCRBY orderId 100   // redis批量生成序号提升性能

- 内部编码
  - 整型(int)
  - embstr编码的简单动态字符串
  - raw编码的简单动态字符串





