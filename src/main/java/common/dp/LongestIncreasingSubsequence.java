package common.dp;
public class LongestIncreasingSubsequence {

    public static int longestIncreasingSubsequence(int[] nums){
        int n = nums.length;
        if(n <1){
            return 0;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        int max =0;
        for(int i=1;i<nums.length;i++){
            int preMax = 0;
            for(int j=0;j<i;j++){
                if(nums[j] < nums[i] && preMax < dp[j]){
                    preMax = dp[j];
                }
            }
            dp[i] = preMax +1;
        }

        for(int k=0;k<n;k++){
            if(max < dp[k]){
                max = dp[k];
            }
        }
        return Math.max(dp[n-1],max);
    }
}
