# 如何在Spring所有Bean创建完后做扩展
### 说明

- 哪里才算所有的Bean创建完？
  - new ApplicationContext()----->refresh()----->finishBeanFactoryInitialization(循环所有的BeanDefinition,通过BeanFactory.getBean()生成所有的Bean) 这个循环结束之后所有的bean就创建完了
    
- 方法
  1. 实现SmartInitializingSingleton，在afterSingletonInstantiated()方法中扩展
  2. 创建监听器 监听ContextRefreshedEvent事件
     - @EventListner(ContextRefreshedEvent.class)
     - public void onApplicationEvent(ContextRefreshedEvent event){ 扩展}
