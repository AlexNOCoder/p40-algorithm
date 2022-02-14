# BeanDefinition的加载过程

### 说明

1. @Bean new AnnotationApplicationContext
2. BeanDefinitonReader读取配置
3. ConfigurationClassParser调用解析@Bean、@Import、@Component
4. ClassPathBeanDefinitionScanner 中doScan方法扫描：根据包路径，找到所有.class文件，判断类是不是标注了@Component注解，排除接口、抽象类
5. 然后注册到BeanDefinitionMap