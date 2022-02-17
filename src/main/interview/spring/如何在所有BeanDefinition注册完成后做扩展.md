# 如何在所有BeanDefinition注册完成后做扩展

### 说明
1. 实现BeanFactoryPostProcessor接口
2. 并加上@Component交给Spring管理
3. 在postProcessBeanFacotry方法里就可以执行扩展方法