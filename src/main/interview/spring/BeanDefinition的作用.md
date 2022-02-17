# BeanDefinition的作用

### 说明
- BeanDefinition的作用
  - 它主要负责存储Bean的定义信息：决定Bean的生产方式。
  - 后续BeanFactory根据这些信息就能生产Bean：比如实例化  可以通过call进行反射进而得到实例对象，比如lazy 则不糊在IoC加载时创建Bean
### 步骤
1. 配置Bean： <bean> @Component @Scope @Lazy @Bean
2. 然后根据Bean的配置生成BeanDefinition，BeanFactory才能根据BeanDefinition生成bean
3. 多个Bean就需要多个BeanDefinition，存放在BeanDefinitionMap中<beanName,beanDefinition>
4. 然后循环BeanDefinitionMap，去生成bean