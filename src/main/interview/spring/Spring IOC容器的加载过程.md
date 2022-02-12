#Spring IOC容器的加载过程
### 过程说明

- 从概念态到定义态
1. 实例化一个ApplicationContext的对象
1. 调用bean工厂后置处理器完成扫描 invokeBeanFactoryPostProcessors
1. 循环解析扫描出来的类信息，有@Commponent
1. 实例化一个BeanDefinition对象来存储解析出来的信息
1. 把实例化的BeanDefinition对象put到beanDefinitionMap中缓存起来，以便后面实例化bean
1. 再次调用其他bean工厂的后置处理器
- 从定义态到纯净态
1. 当然spring还会干很多事情，比如国际化，比如注册BeanPostProcessor等等，如果我们只关心如何实例化一个bean的话，这一步就是spring调用finishBeanFactoryInitialization方法来实例化单例的bean，实例化之前spring要做验证，需要遍历所有扫描出来的类，依次判断这个bean是否Lazy，是否prototype，是否abstract等等,
1. 如果验证完成spring在实例化一个bean之后需要推断构造方法，因为spring实例化对象时通过构造方法反射，故而需要知道哪个构造方法
1. 推断完构造方法之后spring调用构造方法实例化一个对象；注意我这里说的是对象、对象、对象、这个时候对象已经实例化出来了，但是并不是一个完整的bean，最简单的体现是这个时候实例化出来的对象属性是没有注入(DI)，所以不是一个完整的bean；
- 从纯净态到成熟态
1. spring处理合并的BeanDefinition
1. 判断需要完成属性注入DI
1. 如果需要完成属性注入，则开始注入属性
- 初始化
1. 判断bean的类型回调Aware接口
1. 调用生命周期回调方法
1. 如果需要代理则完成代理 AOP
- 完成
1. put到单例池 --bean完成 --- 存在spring容器当中