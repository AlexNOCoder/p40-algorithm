package number_of_longest_increasing_subsequence_673;

public class SolutionByAlex {
    public static int findNumberOfLIS(int[] nums) {
        //对于某一个位置最长的递增子序列可能有多种可能
        //对于一个数组中，可能有不同的位置含有最长的递增子序列
        //用dp数组存包含这个位置的最大的递增子序列长度
        //用result数组包含这个位置的最大的递增子序列长度的可能情况
        int n = nums.length;
        if(n < 1){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        int[] dp = new int[n];
        int[] result  = new int[n];
        for(int m = 0;m< n;m++){
            result[m] = 1;
        }
        dp[0] = 1;
        int max = 0;
        for(int i=1;i<n;i++){
            int tempMax =0;
            for(int j=0;j<i;j++){
                //需要包含本节点，则只看比本节点小的dp[j]
               if(nums[i] >  nums[j]){
                   if(tempMax == dp[j]){
                       //如果此时的最大值和当前的dp[j]相同，可能性就加上result[j]的可能性
                       result[i] += result[j];
                   }else if(tempMax < dp[j]){
                       //如果当前值大于此时的最大值，则重新赋值最大值，并把result的计数置为result[j]
                       result[i] = result[j];
                   }
                   //根据现有的值是否大于最大值来更新最大值
                   tempMax = Math.max(tempMax, dp[j]);
               }
            }
            System.out.println("result："+i+"; "+result[i]);
            //更新dp[i]节点; dp[i]  = max(dp[j]) +1 (其中j小于i)
            dp[i] = tempMax + 1;
            //更新现在的最长递增子序列长度
            if(max <  dp[i]){
                max  = dp[i];
            }
        }
        //统计最长的递增子序列的所有可能性
        int count =0;
        for(int k=0;k<n;k++){
            if(max == dp[k]){
                count += result[k];
            }
        }
        return count;
    }

    public static void main(String[] args) {
//        int[] nums ={1,3,5,4,7};
        //[1, 3, 4, 7] and [1, 3, 5, 7]
        int[] nums = {1,2,4,3,5,4,7,2};
        System.out.println(findNumberOfLIS(nums));
    }
}
