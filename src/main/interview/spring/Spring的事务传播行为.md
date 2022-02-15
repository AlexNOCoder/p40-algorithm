# Spring的事务传播行为
### 说明
事务的传播特性指的是当一个事务方法被另一个事务方法调用时，这个事务方法应该如何进行。

### 代码示例
```java
@Transactional 
public void trans(){
  sub();
  log();
  query();
}

@Transactional SUPPORTS
public info query(){
   //  do sth..
 }
 
@Transactional REQUIRES_NEW
public void log(){
   //  记录日志
}
```
### 传播行为介绍
| 事务传播行为类型 | 外部不存在事务 | 外部存在事务                                              | 使用方式                                                                                            |
| ---------------- | -------------- | --------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------- |
| REQUIRED(默认) | 开启新的事务 | 融合到外部事务中                                        | @Transactional(propagation = Propagation.REQUIRED) 适用于增删改查                                |
| SUPPORTS         | 不开启新事务 | 融合到外部事务中                                        | @Transactional(propagation = Propagation.SUPPORTS) 适用于查询                                      |
| REQUIRES_NEW     | 开启新的事务 | 不用外部事务，创建新的事务                         | @Transactional(propagation= Propagation.REQUIRES.NEW)适用于内部事务和外部事务不存在业务关联情况，如日志 |
| NOT_SUPPORTED    | 不开启新的事务 | 不用外部事务                                              | @Transactional(propagation=Propagation.NOT_SUPPORTED)  不常用                                        |
| NEVER            | 不开启新的事务 | 抛出异常                                                    | @Transactional(propagation = Propagation.NEVER）不常用 |
| MANDATORY        | 抛出异常   | 融合到外部事务中                                        | @Transactional(propagation = Propagation.MANDATORY) 不常用                                           |
| NESTED           | 开启新的事务 | 融合到外部事务中，SavePoint机制，外层影响内层，内层不会影响外层 | @Transactional(propagation = Propagation.NESTED) 不常用|
