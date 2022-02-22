# bean有哪些生命周期回调方法
### 说明

1. 初始化调用 按照下面顺序
   - @PostConstruct 被注解标注的方法
   - InitializingBean afterPropertiesSet
   - init-method 通过配置指定的方法 （只能通过<bean> 或者@Bean方式配置，@Component没有地方配置）
2. 销毁时调用（applicationContext 调用close()方法时销毁）
   - @PreDestroy 被注解标注的方法
   - DisposableBean destroy
   - destroy-method 通过配置指定的方法
 
 
 
 三种方式：
 1. 接口方式
   - 实现spring中的InitializingBean接口，实现其中的afterPropertiesSet()方法，将会在
   Spring容器初始化之后（依赖注入之后）进行调用
   - 实现spring中的DisposableBean接口，实现其中的destory()方法，将会在spring销毁之前调用
   
 2. 注解方式
   - @PostConStruct和@PreDestory注解也可以实现相同的功能，这两个注解有jdk提供
   
 3. init-method和destory-method方式
   - 在我们使用xml来进行bean的配置
 #注
 - 在一个Bean中可以同时按照以上三种方式来指定三个生命周期回调方法。执行顺序是：
 注解方式 -->接口方式 --> xml指定的方式。这些生命周期都由spring的
 CommonAnnotationBeanPosProcessor后置处理器按顺序进行处理。
 - 若想在Spring IOC容器初始化之后、销毁之前执行自定义的生命周期回调方法，
 可以实现SmartLifeCycle接口。