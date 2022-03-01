# GCRoots是什么

### 说明

在java技术体系里面，固定可作为GC Roots的对象包括以下几种：
- 在虚拟机栈(栈帧中的本地变量表)中引用的对象，譬如各个线程被调用的方法堆栈中使用到的参数、局部变量、临时变量等。
- 在方法区中静态属性引用的对象，譬如java类的引用类型静态变量
- 在方法区中常量引用的对象，譬如字符串常量池(String Table)里的引用
- 在本地方法栈中JNI(即通常所说的Native方法)引用对象
- java虚拟机内部的引用，如基本数据类型对应的Class对象，一些常驻的异常对象(比如NullPointException、OutOfMemoryError)等，还有系统类加载器
- 所有被同步锁(synchronized关键字)持有的对象
- 反映java虚拟机内部情况的JMXBean、JVMTI中注册的回调、本地代码缓存等。