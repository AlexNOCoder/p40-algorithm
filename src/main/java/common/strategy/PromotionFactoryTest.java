package common.strategy;
public class PromotionFactoryTest {
    public static void main(String[] args) {
        String promotionKey = "GROUPBUY";
        PromotionActivity promotionActivity = new PromotionActivity(PromotionStrategyFactory.getPromotionStragety(promotionKey));
        promotionActivity.execute();
    }
}
