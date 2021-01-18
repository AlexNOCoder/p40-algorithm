package common.designPattern.strategy.payStrategy;
public class WechatPay extends Payment{

    @Override
    public String getName() {
        return "微信支付";
    }

    @Override
    protected double queryBalance(String uid) {
        return 200;
    }
}
