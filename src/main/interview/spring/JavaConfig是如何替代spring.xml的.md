# JavaConfig是如何替代spring.xml的

### 应用

- 以前Xml
  1. Spring 容器 new ClassPathXmlApplicationContext("xml")
  1. Spring.xml
  1. <bean scope lazy>
  1. 扫描包: <componet-scan>
  1. 引入外部属性配置文件 <property-placeHodeler resource ="xx.properties">
  1. <property name="password" value ="${mysql.password}"> </property>
  1. 指定其他配置文件<import resource=“”>
- javaConfig
  1. Spring 容器 new AnnotationConfigApplicationContext(javaconfig.class)
  1. 配置类 @Configuration
  1. @Bean @Scope @Lazy
  1. @ComponentScan
  1. @PropertySource("classpath:db.properties")
  1. @Value("${mysql.password}")
  1. @Import @Import{配置类}使用比较灵活
    

### 源码

- 区别在于ClassPathXmlApplicationContext加载xml，而AnnotationConfigApplicationContext加载配置类，但都会注册BeanDefinition

- AnnotationConfigApplicationContext加载配置类流程
  1. 读取配置类 
     - AnnotationBeanDefinitionReader 的this.reader.register(annotationClasses)
  1. 解析配置类
     - BeanDefinitionRegistryPostProcess ConfigurationClassParser配置类解析器：解析各种注解@Bean @Component
  1. 注册为BeanDefinition

- ClassPathXmlApplicationContext加载xml流程
  1. 读取xml配置文件
     - XmlBeanDefinitionReader AbstractXmlApplicationContext的loadBeanDefinition()
  1. 解析配置文件
     - LoadBeanDefinition  DefaultBeanDefinitionDocumentReader 解析 <bean> <import>.. 
       
  1. 注册为BeanDefinition