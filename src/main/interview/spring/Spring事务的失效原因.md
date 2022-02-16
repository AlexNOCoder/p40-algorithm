# Spring事务的失效原因

### 使用不当
1. 方法是private也会失效，解决：改成public
2. 目标类没有配置为Bean也会失效，解决：配置为Bean
3. 自己捕获了异常  解决：不要捕获异常
4.使用CGLIB动态代理，但是@Transactional声明在接口上面

### AOP原因
**内部调用不会触发AOP**
解决办法：
1. 在本类中自动注入当前的bean
2. 设置暴露本类代理对象到本地线程，可以通过AopContext.currentProxy()拿到当前正确调用的动态代理对象
   - @EnableAspectJAutoProxy(exposeProxy = true)
