package common.dp;
public class LongestIncreasingSubsequence {

    public static int longestIncreasingSubsequence(int[] nums){
        int n = nums.length;
        //开辟空间
        int[] f = new int[n];

        //初始化
        f[0] =1;

        int maxans = f[0];
        for(int i=1;i<n;i++){
            //因为后面是max，先设置为1
            f[i] =1;
            for(int j=0;j<i;j++){
                if(nums[i] > nums[j]){
                    f[i] = Math.max(f[i],f[j]+1);
                }
            }
            maxans =Math.max(maxans,f[i]);
        }

        return maxans;
    }
}
