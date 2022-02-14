#为什么Springboot的jar可以直接运行

### 说明

1. SpringBoot提供了一个插件spring-boot-maven-plugin用于把程序打包成一个可执行的jar包
2. Spring Boot应用打包之后，生成一个Fat jar(jar包中包含jar)，包含了应用依赖的jar包和Spring Boot loader相关的类
3. java -jar 会去找jar中的mannifest文件，在那里面找到正在的启动类(Main-Class)
4. Fat jar的启动Main函数是JarLauncher，它负责创建一个LaunchedURLClassLoader来加载boot-lib下面的jar，并以一个新线程启动应用的Main函数(mannifest中的Start-Class)