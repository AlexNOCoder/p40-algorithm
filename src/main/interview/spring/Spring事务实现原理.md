# Spring事务实现原理
### 说明

- 使用： @EnableTransactionManagement

- 原理：
  - 解析切面  -->bean的创建前第一个bean的后置处理器进行解析advisor(pointcut(通过@Transactional解析的切点),advise)
  （这个advisor是通过@EnableTransactionManagement注册了一个配置类，该配置类就配置了advisor）
  - 创建动态代理  --> bean的初始化后调用bean的后置处理器进行创建动态代理(有接口使用jdk，没有接口使用CGLIB)，创建动态代理之前会
  先根据advisor中pointcut匹配@Transactional(方法里面是不是有、类上面是不是有、接口或者父类上面是不是有)，匹配到就创建动态代理
  - 调用
    1. Spring事务底层是基于数据库事务和AOP机制(即同样也通过BeanPostProcessor解析机切面和创建动态代理)
    1. 为使用了@Transactional注解的Bean创建一个代理。
    1. 如果是事务方法(类上面、接口上面、方法上面、接口方法上面)开始事务：
    1. try{   1. 创建一个数据库连接 并且修改数据库连接的autocommit属性为false，禁止此连接的自动提交，这是实现Spring事务非常重要的一步 
    2.然后执行目标方法，方法中会执行数据库操作sql } catch{ 如果出现异常，并且这个异常是需要回滚的就会回滚事务，否则仍然提交事务}
    1. 执行完当前方法后，如果没有出现异常就直接提交