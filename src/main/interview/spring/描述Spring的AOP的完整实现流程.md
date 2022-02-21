# 描述Spring的AOP的完整实现流程
### 说明

- AOP的实现大致分为三大步：JavaConfig为例
- 当@EnableAspectJAutoProxy会通过@Import注册一个BeanPostProcessor处理AOP

1. 解析切面：在Bean创建之前的第一个Bean后置处理器会去解析切面(解析切面中通知、切点，一个通知就会解析成一个advisor(通知、切点))
1. 创建动态代理 正常的Bean初始化后调用BeanPostProcessor拿到之前缓存的advisor，在通过advisor中pointCut判断当前Bean是否被切点表达式匹配，如果匹配，就会为Bean创建动态代理(创建方式：1.jdk动态代理2.cglib)
1. 调用：拿到动态代理对象，代用方法就会判断当前方法是否是增强的方法，就会通过调用链的方式依次去执行通知