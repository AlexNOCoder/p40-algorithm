# Spring Boot、SpringMVC和Spring的区别
1. spring是一个IOC容器，用来管理Bean，通过依赖注入实现控制反转，可以很方便的整合各种框架，提供AOP机制
弥补OOP的代码重复问题，更方便将不同类不同方法中的共同处理逻辑的部分抽取成切面，自动注入给方法执行，
比如日志、异常等。
2. spring mvc是spring对web框架的一个解决方案，提供了一个总的前端控制器（DispatcherServlet），
用来接收请求，然后定义了一套路由策略（URL到handle的映射，策略模式）及适配执行handle(适配器模式)，
将handle结果使用视图技术生产视图展现给前端
3. springboot是spring提供的一个快捷开发工具包，让程序员更方便、更快速的开发spring+spring MVC应用，
简化了配置，整合了一系列的解决方案（starter机制）、Redis、mongodb、es，开箱即用