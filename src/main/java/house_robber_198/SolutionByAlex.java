package house_robber_198;

public class SolutionByAlex {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = nums[0];
        dp[2] = Math.max(nums[0],nums[1]);
        for(int i=3;i<=n;i++){
            dp[i] = Integer.MIN_VALUE;
            for(int j=0;j<i-1;j++){
                dp[i] = Math.max(dp[i-1],(dp[j]+nums[i-1]));
            }
        }
        return dp[n];
    }

}
