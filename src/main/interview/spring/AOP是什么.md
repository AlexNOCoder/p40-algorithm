# AOP是什么

### 说明

AOP就是面向切面编程，是一种非常适合在无需修改业务代码的前提下，对某个或某些业务增加统一的功能，比如日志记录、权限控制、事务管理等，能很好的使得代码解耦，提高开发效率。
AOP中的核心概念
- Advice
Advice可以理解为通知、建议，在Spring中通过定义Advice来定义代理逻辑
- Poincut
  - Pointcut是切点，表示Advice对应的代理逻辑应用在哪个类、哪个方法上。
- Advisor
  - Advisor等于Advice+Pointcut，表示代理逻辑和切点的一个整体，程序员可以通过定义或者封装一个Advisor，来定义切点和代理逻辑。
- Weaving
  - Weaving表示织入，将Advice代理逻辑在源代码级别嵌入到切点的过程，就叫做织入。
- Target
  - Target表示目标对象，也就是被代理对象，在AOP生成的代理对象中会持有目标对象。
- JoinPoint
  - JointPoint表示连接点，在Spring AOP中，就是方法的执行点。

### AOP的工作原理
AOP是发生在Bean的生命周期过程中的：
1. Spring生成Bean对象时，先实例化出来一个对象，也就是target对象
2. 再对target对象进行属性填充
3. 在初始化步骤后，会判断target对象有没有对应的切面
4. 如果有切面，就表示当前target对象需要进行AOP
5. 通过Cglib或者JDK动态代理机制生成一个代理对象，作为最终的bean对象
6. 代理对象中有一个target属性指向了target对象。