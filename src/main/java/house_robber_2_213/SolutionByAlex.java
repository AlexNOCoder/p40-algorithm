package house_robber_2_213;

import java.util.Arrays;

public class SolutionByAlex {
    //使用两次普通的打家劫舍代码处理不包含第一个节点和不包含尾节点的数据，得到的结果再取最值
    public static int rob(int[] nums) {
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        if(n == 2 || n==3){
            return maxValue(nums);
        }
        int[] leftArr = Arrays.copyOfRange(nums,0,n-1);
        int[] rightArr = Arrays.copyOfRange(nums,1,n);
        int left = normalRob(leftArr);
        int right = normalRob(rightArr);
        return Math.max(left,right);
    }

    public static int normalRob(int[] nums) {
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

    public static int maxValue(int[] nums){
        int max = Integer.MIN_VALUE;
        for(int i: nums){
            max = Math.max(max,i);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums1 = {2,3,2};
        int[] nums2 = {1,2,3,1};
//        System.out.println(rob(nums1));
        System.out.println(rob(nums2));
    }
}
