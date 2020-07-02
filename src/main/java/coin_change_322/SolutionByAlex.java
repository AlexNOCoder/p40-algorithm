package coin_change_322;

public class SolutionByAlex {
    public static void main(String[] args) {
        int[] coins = {186,419,83,408};
        int amount = 6249;
        System.out.println(coinChange(coins,amount));
    }

    public static int coinChange(int[] coins, int amount) {
        //创建dp表
        int[] dp = new int[amount+1];
        //种类
        int n = coins.length;
        //初始化
        dp[0] = 0;
        for(int i=1;i < amount+1;i++){
            //初始值设置
            dp[i] = Integer.MAX_VALUE;
            //转移方程
            for(int coin:coins){
                if(i >= coin && dp[i-coin] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i-coin]+1,dp[i]);
                }
            }
        }
        if(dp[amount] < 0 || dp[amount] >amount ){
            dp[amount] = -1;
        }
        return dp[amount];
    }

}
