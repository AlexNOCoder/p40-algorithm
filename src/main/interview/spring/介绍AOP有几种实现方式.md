# 介绍AOP有几种实现方式
### 说明

- Spring1.2 基于接口的配置：最早的Spring AOP是完全基于几个接口的
- Spring2.0  schema-based配置： Spring 2.0以后使用XML的方式来配置，使用命名空间<aop></aop>
- Spring2.0 @AspectJ配置：使用注解的方式来配置，这种方式感觉是最方便的，还有，这里虽然叫做@Aspectj，但是这个和AspectJ其实没有啥关系
- AspectJ方式，这种方式其实和Spring没有关系，采用AspectJ进行动态织入的方式实现AOP，需要用AspectJ单独编译