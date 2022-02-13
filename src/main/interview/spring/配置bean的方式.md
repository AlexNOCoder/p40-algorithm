#配置bean的方式

### 说明

1. xml：<bean class ="com.test.UserService" id ="">
1. 注解：@Component(@Contorller,@Service,@Repostory),前提需要配置扫描包<component-scan>，反射调用构造方法
1. javaConfig: @Bean 通常搭配@Configuration，可以自己控制实例化过程
1. @Import 有三种方式
   - ImportSelector 返回String[],返回的是类路径
   - ImportBeanDefinitionRegistrary 提供了类注册器，可以注册bean
   - @Import（xxxx.class） 直接导入其他配置类，或者导入类注册为Bean