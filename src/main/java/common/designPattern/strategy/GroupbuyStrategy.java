package common.designPattern.strategy;

import java.util.concurrent.ConcurrentHashMap;

public class GroupbuyStrategy implements PromotionStrategy{

    @Override
    public void doPromotion() {
        System.out.println("拼团，满20人成团，全团享受团购价");
    }
}
