# @Import有几种用法

### 说明

1. 直接指定类，即直接填class数组的方式 (如果配置类会按配置类正常解析、如果是个普通类就会解析成Bean)
1. 通过ImportSelector：可以一次性注册多个，返回一个String[]每一个值就是类的完整类路径
   - 通过DeferredImportSelector可以一次性注册多个，返回一个String[]每一个值就是类的完整类路径
     - 区别：DeferredImportSelector 顺序靠后
1. 通过ImportBeanDefinitionRegistrar：可以一次性注册多个，通过BeanDefinitionRegistry来动态注册BeanDefinition（即手动注册bean容器）