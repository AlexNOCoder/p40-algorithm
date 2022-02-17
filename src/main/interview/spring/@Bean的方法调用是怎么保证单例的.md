# @Bean的方法调用是怎么保证单例的

### 说明

- 与@Configuration加与不加有什么区别 问题等价

1. 如果希望@Bean方法返回的对象时单例的 需要在类上面加上@Configuration
2. Spring会在invokeBeanFactoryPostProcessor通过内置BeanFactoryPostProcessor中会CGLib生成代理
3. 当@Bean方法进行互相调用时，则会通过CGLIB进行增强，通过调用的方法名作为bean的方法名去ioc容器中获取，从而保证了@Bean方法的单例
