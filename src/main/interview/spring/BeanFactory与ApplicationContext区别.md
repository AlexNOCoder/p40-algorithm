#BeanFactory与ApplicationContext区别

### 区别说明


- BeanFactory的getBean方法用于生产bean，优点：内存占用率小，因为BeanFactory是延迟加载的方式注入Bean，
在第一次调用getBean的时候才会创建Bean
- ApplicationContext实现了FactoryBean，它不生产Bean而是通知BeanFactory来进行生产，
 getBean是一个门面方法，ApplicationContext是在容器启动时一次创建所有的Bean，所以内存占用率大，启
 动会较慢
- BeanFactory通常以编程的方式被创建，而ApplicationContext还能以声明的方式，比如ContextLoader
- BeanFactory和ApplicationContext都支持BeanPostProseProcessor和BeanFactoryPostProcessor
的使用，两者的区别是BeanFactory是手动注册的，ApplicationContext是自动注册的
- ApplicationContext做的事情更多：
   1. 会自动帮我们把我们配置的bean扫描出来，注册为BeanDefinition
   1. 加载环境变量
   1. 支持多语言(国际化)，因为继承了MessageSource
   1. 实现事件监听
   1. 注册很多对外扩展点
- 共同点：都可作为bean的容器，管理Bean的生命周期
- 关系：ApplicationContext实现了FactoryBean

### 总结
ApplicationContext相当于4s店做得更多，BeanFactory相当于汽车工厂。