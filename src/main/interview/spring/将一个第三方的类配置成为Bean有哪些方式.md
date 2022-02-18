# 将一个第三方的类配置成为Bean有哪些方式

### 说明

1. 在@Configuration类里面@Bean配置一个返回new xxx()的方法
1. 使用import(xxx.class) 不能干预实例化过程
1. 使用Import(实现ImportSelector的类)，返回完整类路径，不能干预实例化过程
1. 使用import(实现ImportBeanDefinitionRegistrar的类)，自定义BeanDefinition然后注册，可以干预实例化过程
1. 使用import(实现BeanDefinitionRegistryPostProcessor接口)，自定义BeanDefinition然后注册，可以干预实例化过程