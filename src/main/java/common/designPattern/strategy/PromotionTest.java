package common.designPattern.strategy;
public class PromotionTest {
    public static void main(String[] args) {
        PromotionActivity active618 = new PromotionActivity(new CouponStrategy());
        PromotionActivity active1111 = new PromotionActivity(new CrashbackStrategy());

        active618.execute();
        active1111.execute();
    }
}
