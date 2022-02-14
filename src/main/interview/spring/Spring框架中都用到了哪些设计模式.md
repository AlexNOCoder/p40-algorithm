#Spring框架中都用到了哪些设计模式
### 说明

- **简单工厂**  BeanFactory
- **工厂方法**  FactoryBean
- **单例模式**  Bean实例
- **适配器模式**  SpringMVC中的HandlerAdapter
- **装饰器模式**  BeanWrapper
- **代理模式**  AOP底层
- **观察者模式** Spring的事件监听
- **策略模式** excludeFilters、includeFilters
- **模板方法模式**  Spring几乎所有的外接扩展接口都采用这种模式
- **责任链模式**  AOP的方法调用