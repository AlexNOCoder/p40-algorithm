# java.lang.invoke与反射调用的区别

### 说明

JDK7时新加入的java.lang.invoke包，这个包的主要目的是在之前单纯依靠符号引用来确定调用的目标方法这条路之外，提供一种新的动态确定目标方法的机制，称为"方法句柄"（Method Handle）

- Reflection和MethodHandle机制本质上都是在模拟方法调用，但是Reflection是在模拟java代码层次的方法调用，而MethodHandle是在模拟字节码层次的方法调用。
- 在Methodhandle.LoopUp上的3个方法findStatic()、findVirtual()、findSpecial()正式为了对应于invokestatic、invokevirtual(以及invokeinterface)和invokespecial这几条字节码指令的执行权限校验行为，而这些底层细节在使用Reflection API时是不需要关心的。
- Reflection中的java.lang.reflect.Method对象远比MethodHandle机制中的java.lang.invoke.MethodHandle对象所包含的信息来得多。前者是方法在Java端的全面映像，包含了方法的签名、描述符以及方法属性表中各种属性的java端表示方式，还包含执行权限等的运行期信息。
而后者仅包含执行该方法的相关信息。用开发人员通俗的话来讲，Reflection是重量级，而MethodHandle是轻量级。