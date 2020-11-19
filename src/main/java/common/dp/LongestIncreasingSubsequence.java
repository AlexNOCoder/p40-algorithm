package common.dp;
public class LongestIncreasingSubsequence {

    public static int longestIncreasingSubsequence(int[] nums){
        int n = nums.length;
        //case input为空数组情况
        if(n <1){
            return 0;
        }
        //开辟数组
        int[] f = new int[n];
        //初始化
        f[0] = 1;
        //初始化结果，最大值为dp[0]
        int max =f[0];
        //从小到大遍历
        for(int i=1 ;i<nums.length; i++){
            //初始化最大值
            f[i] =1;
            for(int j=0 ; j<i ;j++){
                if(nums[j] < nums[i]){
                    f[i] = Math.max(f[i],f[j]+1);
                }
            }
            max = Math.max(max,f[i]);
        }
        return max;
    }
}
