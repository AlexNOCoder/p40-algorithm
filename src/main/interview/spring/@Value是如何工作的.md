#@Value是如何工作的

### 说明
  - @Vaue注解和@Resource、@Autowired注解类似，也是用来对属性进行依赖注入的，只不过@Value是用来从Properties文件中来获取值的，并且@Value可以解析SpEL（Spring表达式）。
  - @Value("lyt")
    - 直接将“lyt”赋值给属性，如果属性类型不是String，或无法进行类型转换，则报错 
      
  - @Value("${lyt}")
    - 将会把${}中的字符串当做key,从Proerties文件中找到对应的value赋值给属性，如果没有找到，则会把“${lyt}”当做普通字符串注入给属性
    
  - @Value("#{lyt}")
    - 会将#{}中的字符串当做Spring表达式进行解析，Spring会把“lyt”当做beanName，并从Spring容器中找到bean，如果找到则进行属性注入，没有找到则报错。

