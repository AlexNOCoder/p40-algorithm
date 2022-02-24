# Class文件常量池中存放的什么内容
### 说明

- 常量池中主要存放两大类常量：字面量(Literal)和符号引用(Symbolic Referrences)

- 字面量比较接近于Java语言层面的常量概念，比如文本字符串、被声明为final的常量值等。

- 符号引用则属于编译原理方面的概念，主要包括下面几类常量：
1. 被模块到处或者开放的包 Package
1. 类和接口的权限定名 Fully Qualified Name
1. 字段的名称和描述符 Descriptor
1. 方法的名称和描述符
1. 方法句柄和方法类型 Method Handle、Method Type、Invoke Dynamic
1. 动态调用点和动态常量 Dynamically-Computed、Call Site、Dynamically-Computed、Constant