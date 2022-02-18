# Spring支持的事务管理类型
### 说明
- Spring支持两种类型的事务： 
  
  - 编程式事务管理：这意味着你通过编程的方式管理事务，给你带来极大的灵活性，但是难维护
    1. JDBC的方式，先conn.setAutoCommit(false)，然后执行数据库操作，最后再commit；并且在catch方法里conn.rollback();
    1. Spirng的方式,先@Autowired TransationTemplate，然后开启事务数据保存数据:boolean result = transationTemplate.execute(new TransactionCallback<booelan>(){      doInTransaction方法，最后再catch里status.setRollbackOnly() });
  - 声明式事务管理：这意味着你可以将业务代码和事务管理分离，你只需用注解和XML配置来管理事务。