# BeanPostPorcessor是什么

### 说明
- BeanPostProcessor是Spring所提供的一种扩展机制，可以利用该机制对Bean进行定制化加工，在Spring底层源码实现中，也广泛的用到了该机制，BeanPostProcessor通常也叫做Bean后置处理器。
- BeanPostProcessor在Spring中时一个接口，我们定义一个后置处理器，就是提供一个类实现该接口，在Spring中还存在一些接口继承了BeanPostProcessor，这些子接口是在BeanPostProcessor的基础上增加了一些其他功能。

BeanPostProcessor中的方法：
 - postProcessorBeforeInitialization():初始化前方法，表示可以利用该方法来对bean在初始化前进行自定义加工。
 - postProcessorAfterInitialization():初始化后方法，表示可以利用该方法来对bena在初始化后进行自定义加工。

### 加餐
说明InstantiationAwareBeanPostProcessor是什么
  - BeanPostProcessor的一个子接口，
  - postProcessBeforeInstantiation():实例化前
  - postProcessAfterInstantiation():实例化后 
  - postProcessProperties():属性注入后