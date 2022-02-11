# FactoryBean是什么

### 说明
FactoryBean是Spring提供的一种较为灵活的创建Bean的方式，可以通过实现FactoryBean接口中的getObject()方法来返回一个对象，这个对象就是最终的Bean对象。

FactoryBean接口中的方法
 - Object getObject() :返回的是Bean对象
 - boolean isSingleton)(): 返回的是否是单例Bean对象
 - Class getObjectType(): 返回的是Bean对象的类型

### 示例
1. 一个类实现FactoryBean对象。例如StudentFactory类实现FactoryBean对象，实际上有两个Bean对象
2. 一个是beanName为student，bean对象为getObject方法返回的Student对象。
3. 一个是beannName为&student，bean对象为StudentFactoryBean类的实例对象。

### 总结
- FactoryBean对象本身也是一个Bean，同时它相当于一个小型工厂，可以生成出另外的Bean。
- BeanFactory是一个Spring容器，是一个大的工厂，它可以生产出各种各样的Bean。
- FactoryBean机制被广泛的应用在Spring内部和Spring与第三方框架或组件的整合过程中。