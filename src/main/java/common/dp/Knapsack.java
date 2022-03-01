package common.dp;

/**
 * @author luoyuntian
 * @program: p40-algorithm
 * @description: 背包问题
 * @date 2022-02-27 14:57:21
 */
public class Knapsack {


    public static int maxValue1(int [] weight,int[] value,int bagLimit){
        return process1(weight,value,0,bagLimit);
    }
    // 递归实现
    // 在0 .... n-1中0...index-1已经不能选了
    // index... n-1这些货，自由选择
    // 背包还剩下多少容量，rest，自由挑选是不能超过rest的
    // index...n-1 在符合要求的情况下，最大价值能达多少
    public static int process1(int[] weight,int[] value,int index,int rest){
        // 剩余的负重是负数，说明之前的选择是错误的
        if(rest < 0){
            // 返回无效解
            return -1;
        }
        // rest >=0去且无货了
        if(index == weight.length){
            return 0;
        }
        // 既有负重，又有货
        // 第一种选择：当前index位置的货，没要
        int p1 = process1(weight,value,index+1,rest);
        // 第二种选择：当前index位置的货，要
        int p2 = -1;
        int next = process1(weight,value,index+1,rest-weight[index]);
        if(next != -1){
            p2 = value[index] + next;
        }
        return Math.max(p1,p2);
    }

    public static int maxValue2(int [] weight,int[] value,int bagLimit){
        int n = weight.length;
        // index：0... n
        // bag:100 0...100
        int[][] dp = new int[n+1][bagLimit+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=bagLimit;j++){
                dp[i][j] = -2;
            }
        }
        return process2(weight,value,0,bagLimit,dp);
    }

    public static int process2(int[] weight,int[] value,int index,int rest,int[][] dp){
        if(rest < 0){
            return -1;
        }
        // 缓存命中，以前算过
        if(dp[index][rest]!=-2){
            return dp[index][rest];
        }
        // 缓存没命中
        int ans = 0;
        if(index == weight.length){
            ans = 0;
        }else {
            // 既有负重，又有货
            // 第一种选择：当前index位置的货，没要
            int p1 = process2(weight,value,index+1,rest,dp);
            // 第二种选择：当前index位置的货，要
            int p2 = -1;
            int next = process2(weight,value,index+1,rest-weight[index],dp);
            if(next != -1){
                p2 = value[index] + next;
            }
            ans = Math.max(p1,p2);
        }
        dp[index][rest] = ans;
        return ans;
    }
}
