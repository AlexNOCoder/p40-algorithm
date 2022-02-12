# Spring IoC过程的扩展点

### 扩展点说明



1. 执行BeanFactoryPostProcessor的postProcessorBeanFactory方法
1. 执行BeanDefinitionRegistryPostProcessor的postProcessorBeanDefinitionRegistry方法
1. 在实例化一个ApplicationContext方法的时候，会调用refresh方法，它体现了整个IoC的加载过程。
1. 在refresh方法中调用invokeBeanFactoryPostProcessor ，IoC加载注册BeanDefinition时候会调用BeanDefinitionRegestoryPostProcessor 动态注册BeanDeinition(接口，RootBeanDefinition实现)，然后调用BeanFactoryPostProcessor（被BeanDefinitionRegestoryPostProcessor继承），在注册BeanDefinition的时候，可以对BeanFactory进行扩展。
1. 加载BeanPostProcessor实现类： 在Bean的生命周期会调用9次Bean的后置处理器

**创建所有单例Bean**
   
1. 初始化阶段
1. 初始化阶段调用XXXAware接口的SetXXXAware方法，实现XXXAware提供了XXX的扩展方法

**生命周期的回调：初始化、销毁**
   
1. 执行BeanPostProcessor实现类的postProcessorBeforeInitialization方法
1. 执行IntializingBean实现类的afterPropertiesSet方法
1. 执行bean的init-method属性指定的初始化方法
1. 执行BeanPostProcessor实现类postProcessAfterInitialization方法

**初始化完成**
   
1. 关闭容器，执行DiposibleBean实现类destory
1. 执行bean的destory-method属性指定的是初始化方法
