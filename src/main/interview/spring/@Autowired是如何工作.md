# @Autowired是如何工作
1. @Autowired表示某个属性是否需要进行依赖注入，可以写在属性和方法上。注解中的required属性默认为true，表示如果没有对象可以注入给属性则抛异常。
2. @Autowired加在某个属性上，Spring在进行Bean的生命周期过程中，在属性填充这一步，会基于实例化出来的对象，对该对象中加入了@Autowired的属性自动给属性赋值。
3. Spring会先根据属性的类型去Spring容器中找出该类型所有的Bean对象，如果找出来多个，则再根据属性的名字从多个中再确定一个。如果required属性为true，并且根据属性信息找不到对象，则直接抛异常。
4. 当@Autowired注解写在某个方法上时，Spring在Bean生命周期的属性填充阶段，会根据方法的参数类型、参数名字从Spring容器中找到对象当做方法入参，自动反射调用该方法。
5. 当@Autowired加载构造方法上时，Spring会在推断构造方法阶段，选择该构造方法来进行实例化，在反射调用构造方法之前，会先根据构造方法参数类型、方法名从spring容器中找到Bean对象，当做构造方法的入参。