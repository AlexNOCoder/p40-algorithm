# Spring支持的几种bean的作用域

### 说明
- 可以在xml，通过scope字段配置。或者通过@Scope设置

scope有五种：
  - 一种是默认的单例Single
  - 二种是多例 Prototype
  - 三种是Request，必须是web应用才有，一个请求创建一个bean对象
  - 四种是session，必须是web应用才有，一个会话创建一个session对象
  - 五种是application，必须是web应用才有，一个全局的应用共享一个application对象