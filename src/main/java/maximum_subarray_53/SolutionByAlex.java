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
        for(int i=1;i<n;i++){
            dp[i] = nums[i] + Math.max(dp[i-1],0);
            if(max < dp[i]){
                max = dp[i];
            }
        }
        return max;
    }


    //kadane算法的时间复杂度更低，空间复杂度更低
    public static int kadane(int[] nums){
        //遍历数组，将元素依次累加，当累加结果小于等于0时，从下一个元素开始，重新开始累加
        //累加过程中，要用一个变量(max_so_far)记录所获取到的最大值
        //一次遍历后，变量max_so_far中存储的即为最大子片段的和值
        int n = nums.length;
        int max_so_far = Integer.MIN_VALUE;
        int max_end_here = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(max_end_here < 0){
                max_end_here =0;
            }
            max_end_here += nums[i];
            max_so_far = Math.max(max_so_far,max_end_here);
        }
        return max_so_far;
    }


    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
        System.out.println(kadane(nums));
    }

}

