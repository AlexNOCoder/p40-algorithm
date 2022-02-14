#BeanFactory的作用
### 说明

- BeanFactory的作用
  1. BeanFactory是Spring中非常核心的一个顶层接口
  1. 它是Bean的工厂，它的主要职责就是生产Bean
  1. 它实现了简单工厂的设计模式，通过调用getBean传入标识生产一个Bean
  1. 它又非常多的实现类、每个工厂都有不同的职责(单一职责)功能，最强大的工厂是:DefaultListableBeanFactory Spring底层就是使用该实现工厂进行生产Bean的
  1. BeanFactory它也是容器 Spring容器(管理着bean的生命周期)

### 总结
ApplicationContext 通过BeanFactory去生产Bean，然后通过ApplicationContext去getBean才能获取到对象