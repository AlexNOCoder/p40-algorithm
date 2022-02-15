#UML类之间关系

### 泛化 (Generalization)

- 可以理解为继承关系
- 代码演示
    ```java
    public class A{ ... }
    public class B extends A { ... }
    ```

### 实现 (Realization)
- 指接口和实现类之间的关系
- 代码演示
    ```java
    public interface A { ... }
    public class B implements A { ... }
    ```
### 关联 (Association)
- 是一种非常弱的关系，包含聚合和组合两种。
- 具体到代码层面就是B类对象是A类的成员变量，那么B类就是A类的关联关系
    ```java
    public class A {
       private B b;
          public A(B  b){
          this.b = b;
      }
    }
    或者
    public class A{
        private B b;
        public A(){
         this .b = new B();
     }
    }
    ```

### 聚合 (Aggregation)
- 是一种包含关系
- A类对象包含B类对象，B类对象的生命周期可以不依赖A类对象的生命周期
- 也就是可以单独销毁A类对象而不影响B对象
- 代码演示
    ```java
    public class A {
       private B b;
       public A(B b){
       this. b = b;
     }
    }
    ```
### 组合 (Composition)
- 是一种包含关系
- A类对象包含B类对象，B类对象的生命周期跟依赖A类对象的生命周期
- B类对象不可能单独存在
- 代码演示
    ```java
    public class A{
       private B b;
        public A(){
        this.b = new B();
     }
    }
    ```

### 依赖 (Dependency)
- 是一种比关联关系更加弱的关系，包含关联关系。
- 不管是B类对象是A类对象的成员变量
- 还是A类对象使用B类对象作为参数或者返回值、局部变量
- 只要B类对象和A类对象有任何使用关系，都可以称它们有依赖关系
    - 代码演示
    ```java
    public class A{
       private B b;
        public A(B b){
        this. b = b;
     }
    }
    或者
    public class A{
       private B b;
        public A(){
        this.b = new B();
     }
    }
    或者
    public class A{
      public void func(B b){ .... }
    ```