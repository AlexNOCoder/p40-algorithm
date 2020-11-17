package maximum_subarray_53;


public class SolutionByAlex {
    public static int maxSubArray(int[] nums) {
        //最大连续子数组
        //子数组是连续的
        //对于dp[i]表示[0...1]最大的子序列的值
        //如果前一位的最大子序列之和大于0了，就把前面的舍去
        //dp[i] = nums[i] + Math.max(dp[i-1],0)
        int n= nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = dp[0];
//        for(int i=1;i<n;i++){
//            dp[i] = nums[i] + Math.max(dp[i-1],0);
//            if(max < dp[i]){
//                max = dp[i];
//            }
//        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }

}

