#Springboot自动配置原理
### 说明

1. 通过@SpringBootConfiguration引入@EnableAutoConfiguration(负责启动自动配置功能)
2. @EnableAutoConfiguration引入了@Import
3. Spring容器启动时：加载IOC 容器时会解析@Import注解
4. @Import导入了一个deferredImportSelector,它会使SpringBoot的自动配置类的顺序在最后，这样方便我们扩展和覆盖
5. 然后读取所有/META-INF/spring.factories文件
6. 过滤出所有AutoConfigurationClass类型的类
7. 最后通过@Condition排除无效的自动配置类