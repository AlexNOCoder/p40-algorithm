package common.designPattern.strategy.payStrategy;
public class AliPay extends Payment{


    @Override
    public String getName() {
        return "支付宝";
    }

    @Override
    protected double queryBalance(String uid) {
        return 900;
    }
}
