package common.strategy.payStrategy;
public class Order {
    private String uid;
    private String orderId;
    private double amout;

    public Order(String uid, String orderId, double amout) {
        this.uid = uid;
        this.orderId = orderId;
        this.amout = amout;
    }

    //避免了使用switch和if else nice。。
    public PayState pay(){
        return pay(PayStrategy.DEFAULT_PAY);
    }

    public PayState pay(String payKey){
        Payment payment = PayStrategy.getPayment(payKey);
        System.out.println("使用："+payment.getName());
        System.out.println("本次交易金额为： "+amout+",开始扣款。。。");
        return payment.pay(uid,amout);
    }
}
