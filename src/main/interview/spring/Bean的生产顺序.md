# Bean的生产顺序是由什么决定的

### 说明
Bean的创建顺序是由BeanDefinition的注册顺序来决定的，当然依赖关系也会影响Bean创建顺序。(A -B)

- BeanDefinition的注册顺序是由什么决定的？
- 主要由注解(配置)的解析顺序来决定：
  1. @Configuration
  2. @import --  @Configuration
  3. @Component
  4. @Import -- class
  5. @Import -- @Bean
  6. @Bean
  7. @Import -- 实现了ImportBeanDefinitionRegister
  8. BeanDefinitionRegistryPostProcessor