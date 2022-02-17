# spring实例化bean有几种方式
### 方式

- 构造器方式（反射）<bean class="com.test.user">;@Component
  - BeanDefinition.beanClass
- 静态工厂方式 配置 <bean class="com.test.user" id= "user",factory-method = "createUerFactory">; 保证方法是静态的
- 实例工厂方式(@Bean) <bean class="com.test.user" id= "user" factory-bean ="userFacotry" factory-method = "createUerFactoryMethod">;
- FactoryBean方式 实现FactoryBean接口