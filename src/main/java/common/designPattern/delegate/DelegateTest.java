package common.designPattern.delegate;
public class DelegateTest {
    public static void main(String[] args) {

        //客户请求(Boss)、委派者(Leader）、被委派者（Target）
        //委派者要持有被委派的引用
        //代理模式注重的是过程，委派模式注重的是结果
        //策略模式注重是可扩展（外部扩展），委派模式注重内部的灵活和复用
        //委派的核心：就是分发、调度、派遣
        //委派模式：就是静态代理和策略模式的一种特殊组合
        new Boss().command("登录",new Leader());
    }
}
