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