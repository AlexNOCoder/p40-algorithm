# Springmvc的拦截器和过滤器的区别和执行顺序

### 区别

1. 拦截器不依赖于servlet容器，过滤器依赖于servlet容器
2. 拦截器只能对action请求(DispatcherServlet映射的请求)起作用，而过滤器可以对几乎所有的请求起作用
3. 拦截器可以访问容器中的Bean(DI)，而过滤器不能访问(基于spring注册的过滤器也可访问容器中的bean)

### 执行顺序
请求--->Filter --->Servlet ---->Inteceptor --->Controller--->inteceptor--->Servlet---->Filter---->响应