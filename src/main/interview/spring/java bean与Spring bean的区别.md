# java bean与Spring bean的区别
### 说明
- 在spring中，构成应用程序主干并由Spring IoC容器管理的对象称为bean，
 bean是一个由Spring IoC容器实例化，组装和管理的对象。
  - bean就是对象，一个或者多个
  - bean是由spring中IoC的东西管理的
- java的类实例出来的对象就是javaBean

# 答案补充
JavaBean：JavaBean要求所有属性是私有的，该类必须有一个公共无参构造器，
私有属性必须提供公共的getter和setter方法给外部访问
Spring Bean：Spring Bean是spring容器管理的对象

两者的区别：
- 用法不同：传统JavaBean更多的作为值传递参数，而Spring中的Bean用处几乎无处不在，
任何组件都可以被称为Bean
- 写法不同：传统JavaBean作为值对象，要去每个属性都提供getter和setter方法；但Spring
中的Bean只需为接受设置注入的属性提供setter方法
- 生命周期不同：传统Javabean作为值对象传递，不接受任何容器管理生命周期，而Spring中的Bean
有Spring容器管理其生命周期行为
