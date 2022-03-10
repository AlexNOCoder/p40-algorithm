#SpringBoot加载配置文件顺序

###说明
优先级从高到低，高优先级的配置覆盖低优先级配置，所有配置会形成互补配置
1. file:./config/   
   即./config/application.properties
2. file:./config/{@literal *}  
   即./config下面的子文件夹 ./config/xxx/application.properties
3. file:./   
   即./application.properties
4. classpath:config
5. classpath:

## 也可以说：
工程根目录：./config/
2) 工程根目录：./
3)classpath: /config/
4)classpath: /