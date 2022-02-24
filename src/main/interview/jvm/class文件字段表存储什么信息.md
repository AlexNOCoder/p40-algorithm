# class文件字段表存储什么信息
### 说明

- 字段表(field_info)用于描述接口或者类中声明的变量。java语言中的字段包括累计变量以及实例级变量，但不包括方法内部声明的局部变量。
- 字段表存储的其实是变量(非局部变量)的修饰符+字段描述符索引(索引指向常量池)+字段名称索引(索引指向常量池)

- 修饰符：字段可以包括的修饰符有字段的作用域(public、priavte、protected)、是实例变量还是类变量(static)、可变性(final)
、并发可见性(volatile)、可否被序列化(transient)等
  
- 描述符：字段类型

eg.
public final static String NUMBER="1"
public final 和 static是方式的修饰符，这些都存放在clas文件的字段表中
String是字段的描述符，存放在常量池中
NUMBER是字段的名称，存放在常量池中
