#BeanFactory和FactoryBean的区别
### 说明

- BeanFactory
  - 是一个工厂，也就是一个容器，是来管理和生产bean的；
- FactoryBean 
  - 是一个bean，但是它是一个特殊的Bean，所以也是由BeanFactory来管理的。
  - 它是一个接口，他必须被一个bean去实现。实现其getObejct方法后，在通过ApplicationContext通过getObject来获取对象时，
  就是返回的实现后的getObject方法的返回值。可以返回不是实现类的对象，可以是其他对象。在通过ApplicationContext
  通过getObject来获取对象时加上&，就可以获取到原有的对象。
  - 不过FactoryBean不是一个普通的Bean，它会表现出工厂模式的样子，是一个能产生或者修饰对象生成的工厂Bean，
  里面的getObject()即使来获取FactoryBean产生的对象。所以再BeanFatory中使用&来得到FactoryBean本身，
  用来区分通过容器获取FactoryBean参数的对象还是获取FactoryBean本身。FactoryBean并且是懒加载。