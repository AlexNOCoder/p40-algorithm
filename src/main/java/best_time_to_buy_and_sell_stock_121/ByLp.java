package best_time_to_buy_and_sell_stock_121;

/**
 * @Author: lengpei
 * @DATE: 2020/5/19
 **/
public class ByLp {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int max = 0;
        for(int i = 1 ; i<prices.length;i++){
            max = Math.max(prices[i]- min,max);
            if(prices[i]<min){
                min = prices[i];
            }
        }
        return max;
    }
}
