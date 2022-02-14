#Spring事件监听的核心机制

### 原理
**观察者设计模式**

###三个部分组成
- **事件**(ApplicationEvent)： 负责对应相应监听器 事件源发生某事件是特定事件监听器被触发的原因
- **监听器**(ApplicationListener)： 对应于观察者模式中的观察者。监听器监听特定事件，并在内部定义了事件发生后的响应逻辑。
- **事件发布器**(ApplicationEventMulticaster)： 对应于观察者模式中的被观察者/主题，负责通知观察者对外提供发布事件和增删事件监听器的接口，维护事件和事件监听器之间的映射关系，并在事件发生时负责通知相关监听器。


### Spring中内置的事件

- ContextRefreshedEvent ：当容器被实例化或refreshed时发布，如调用refresh()方法，此处的实例化是指所有的bean都已加载，后置处理器都被激活，所有单例bean都已被实例化，所有的容器对象都已经准备好可使用，如果容器支持热重载，则refresh可以被触发多次(XmlWebApplicationContext支持热刷新，而GenericApplicationContext则不支持)
- ContextStartedEvent：当容器启动时发布，即调用start()方法，已启动意味着所有的Lifecycle bean都已经显示收到了start信号
- ContextStoppedEvent：当容器停止发布，即调用stop()方法，即所有的Lifecycle bean都已显式接收到了stop幸好，容器可以通过start()方法重启
- ContextClosedEvent：当容器关闭时发布，即调用close()方法，关闭意味着所有的单例bean都已经被销毁，关闭的容器不能start或refresh
- RequestHandledEvent：这只在使用spring的DispatcherServlet时有效，当一个请求被处理完成时发布