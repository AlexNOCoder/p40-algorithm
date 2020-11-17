package common.dp;

public class MaximumSubarray {
    public static int maximumSubarray(int[] nums){
        //最大连续子数组
        //子数组是连续的
        //对于dp[i]表示[0...1]最大的子序列的值
        //如果前一位的最大子序列之和大于0了，就把前面的舍去
        //dp[i] = nums[i] + Math.max(dp[i-1],0)
        int n= nums.length;
        //开辟数组
        int[] f = new int[n];

        //初始化
        f[0] = nums[0];
        //初始化最大值
        int max = f[0];

        //从小到大遍历
        for(int i=1;i<n;i++){
            //状态转移方程
            f[i] = nums[i] + Math.max(f[i-1],0);

            //更新最大值
            max = Math.max(max,f[i]);
        }
        return max;
    }

}
