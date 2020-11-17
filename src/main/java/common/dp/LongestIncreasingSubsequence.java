package common.dp;
public class LongestIncreasingSubsequence {

    public static int longestIncreasingSubsequence(int[] nums){
        int n = nums.length;
        if(n <1){
            return 0;
        }
        //开辟数组
        int[] dp = new int[n];
        //初始化
        dp[0] = 1;
        //初始化结果，最大值为dp[0]
        int max =dp[0];
        //从小到大遍历
        for(int i=1 ;i<nums.length; i++){
            //初始化最大值
            dp[i] =1;
            for(int j=0 ; j<i ;j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
