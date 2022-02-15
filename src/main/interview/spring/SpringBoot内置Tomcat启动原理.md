#SpringBoot内置Tomcat启动原理

###说明
1. 当依赖Spring-boot-starter-web依赖时会在SpringBoot中添加：ServletWebServerFactoryAutoConfiguration servlet容器自动配置类
2. 该自动配置类通过@Import导入了可用(通过@ConditionOnClass 和@ConditionOnMissingClass 判断决定使用哪一个)的一个Web容器工厂(默认Tomcat)
3. 在内嵌Tomcat类中配置了一个TomcatServletServerFactory的Bean(Web容器工厂)
4. 它会在SpringBoot启动时加载IOC容器(refresh) OnRefresh创建内嵌的Tomcat并启动，tomcat启动后会挂起并等待请求