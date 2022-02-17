# 解释Spring框架中bean的生命周期

### 说明

- Bean的生命周期：指的是Bean从创建到销毁的整个过程，分四步
  1. 实例化
     1. 通过反射去推断构造函数进行实例化 
     1. 实例工厂、静态工厂
  2. 属性赋值
     1. 解析自动装配(byName byType constractur no @Autowired) DI的体现
     1. 循环依赖
  3. 初始化
     1. 调用XXXAware回调方法
     1. 调用初始化生命周期回调(三种)
     1. 如果bean实现AOP，创建动态代理
  4. 销毁
     1. 在spring容器关闭的时候进行调用
     1. 调用销毁生命周期回调
- 步骤如下
     1. 实例化
     1. 填充属性
- 初始化
     1. 调用BeanNameWare的setBeanName()方法 
     1. 调用BeanFactoryAware的setBEanFactory()方法
     1. 调用ApplicationContextAware的setApplicationContext()方法
     1. 调用BeanPostProcessor的预初始化方法
     1. 调用InitializingBean的afterPropertiesSet()方法
     1. 调用自定义的初始化方法
     1. 调用BeanPostProcessor的初始化后方法
- bean可以使用了
- 容器关闭
     1. 调用DisposableBean的destory()方法
     1. 调用自定义的销毁方法