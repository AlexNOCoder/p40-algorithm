# ApplicationContext是什么

### 说明
ApplicationContext是比BeanFactoryBean更加强大的Spring容器，它既可以创建bean、获取bean，还支持国际化，事件广播、获取资源等BeanFacotry不具备的功能。

ApplicationContext所继承的接口
- EnvironmentCapable
  - 表示拥有了获取环境变量的功能，可以通过ApplicationContext获取操作系统环境变量和JVM环境变量。
- ListableBeanFactory
  - 表示拥有了所有beanNames、判断某个beanName是否存在beanDefinition对象、统计BeanDefinition个数、获取某个类型对应的所有beanNames等功能
- HierarchicalBeanFactory
  - 表示拥有了获取BeanFactory、判断某个name是否存在bean对象的功能
- MessageSource
  - 表示拥有了国际化功能，比如可以直接利用MeassgeSource对象获取某个国际化资源(比如不同国家语言所对应的字符)
- ApplicationEventPublisher
  - 表示拥有了事件发布功能，可以发布事件，这是ApplicationContext相对于BeanFactory比较突出、常用的功能
- ResourcePartternResolver
  - 表示拥有了加载并获取资源的功能，这里的资源可以是文件，图片等某个URL资源都可以。