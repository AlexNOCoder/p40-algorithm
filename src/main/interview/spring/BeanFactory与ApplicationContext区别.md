#BeanFactory与ApplicationContext区别

### 区别说明


- BeanFactory的getBean方法用于生产bean，优点：内存占用率小
- ApplicationContext实现了FactoryBean，它不生产Bean而是通知BeanFactory来进行生产，getBean是一个门面方法。
- ApplicationContext做的事情更多：
   1. 会自动帮我们把我们配置的bean扫描出来，注册为BeanDefinition
   1. 加载环境变量
   1. 支持多语言
   1. 实现事件监听
   1. 注册很多对外扩展点
- 共同点：都可作为bean的容器，管理Bean的生命周期
- 关系：ApplicationContext实现了FactoryBean

### 总结
ApplicationContext相当于4s店做得更多，BeanFactory相当于汽车工厂。