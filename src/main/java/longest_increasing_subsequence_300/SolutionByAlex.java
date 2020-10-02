package longest_increasing_subsequence_300;


public class SolutionByAlex {
    public static int lengthOfLIS(int[] nums) {
        //目标：数组中最长上升子序列的长度
        //f(n) 表示n个数字的最长上升子序列的长度
        //对于f(n)可以由max(f(i))+1 其中a[i] < a[n]
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
        System.out.println();
        return Math.max(dp[n-1],max);
     }

    public static void main(String[] args) {
        int[] nums = {1,3,6,7,9,4,10,5,6};
        System.out.println(lengthOfLIS(nums));
    }
    }
