# @Resource是如何工作的

- @Resource注解与@Autowired类似，也是用来进行依赖注入的，@Resource是java层面所提供的注解，
 @Autowired是Spring所提供的注解，它们的依赖注入的底层实现逻辑不同。
- @Resource注解中有一个name属性，针对name属性是否有值，@Resource的依赖注入底层流程是不同的。
- @Resource如果name属性有值，那么spring会直接根据所指定的name值去spring容器中找Bean对象，
 如果找到了则成功，如果没有找到，则报错。
- 如果@Resource中的name属性没有值，则
   1. 先判断该属性名字在Spring容器中是否存在Bean对象
   2. 如果存在，则成功找到Bean对象进行注入
   3. 如果不存在，则根据属性类型去Spring容器找Bean对象，找到一个则进行注入。