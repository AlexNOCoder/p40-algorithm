package common.strategy.payStrategy;
public class PayStrategyTest {
    public static void main(String[] args) {
        Order order = new Order("1","2020101212",321.1);

        System.out.println(order.pay(PayStrategy.ALI_PAY));
    }
}
