package common.strategy.payStrategy;
public class UnionPay extends Payment{

    @Override
    public String getName() {
        return "银联支付";
    }

    @Override
    protected double queryBalance(String uid) {
        return 100;
    }
}
