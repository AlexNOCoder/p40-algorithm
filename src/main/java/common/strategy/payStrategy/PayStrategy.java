package common.strategy.payStrategy;

import java.util.HashMap;
import java.util.Map;

public class PayStrategy {
    //支付策略类

    public static final String ALI_PAY = "AliPay";
    public static final String JD_PAY = "JdPay";
    public static final String UNION_PAY = "UnionPay";
    public static final String WECHAT_PAY = "WechatPay";
    public static final String DEFAULT_PAY = ALI_PAY;

    private static Map<String,Payment> PAYMENT_MAP = new HashMap<>();

    static {

        PAYMENT_MAP.put(ALI_PAY,new AliPay());
        PAYMENT_MAP.put(WECHAT_PAY,new WechatPay());
        PAYMENT_MAP.put(UNION_PAY,new UnionPay());
        PAYMENT_MAP.put(JD_PAY,new JDPay());
    }

    public static Payment getPayment(String payKey){
        if(!PAYMENT_MAP.containsKey(payKey)){
            return PAYMENT_MAP.get(DEFAULT_PAY);
        }
        return PAYMENT_MAP.get(payKey);
    }
}
