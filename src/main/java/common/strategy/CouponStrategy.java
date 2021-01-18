package common.strategy;
public class CouponStrategy implements PromotionStrategy{

    @Override
    public void doPromotion() {
        System.out.println("领取优惠劵，课程价格直接减优惠劵面值抵扣");
    }
}
