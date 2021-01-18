package common.designPattern.strategy.payStrategy;
public abstract class Payment {
    //支付渠道

    public abstract String getName();

    protected abstract double queryBalance(String uid);

    public PayState pay(String uid,double amout){
        if(queryBalance(uid) < amout){
            return new PayState(500,"支付失败","余额不足");
        }
        return new PayState(200,"支付成功","支付金额"+amout);
    }
}
