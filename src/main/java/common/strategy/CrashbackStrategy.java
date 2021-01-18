package common.strategy;
public class CrashbackStrategy implements PromotionStrategy{

    @Override
    public void doPromotion() {
        System.out.println("返现促销，返回的金额转到支付宝账号");
    }
}
