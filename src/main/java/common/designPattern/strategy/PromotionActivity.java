package common.designPattern.strategy;
public class PromotionActivity {
    private PromotionStrategy promotionStrategy;
    public PromotionActivity(PromotionStrategy promotionStrategy){
        this.promotionStrategy = promotionStrategy;
    }

    public void execute(){
        promotionStrategy.doPromotion();
    }
}
