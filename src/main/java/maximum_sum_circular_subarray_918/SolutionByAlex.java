package maximum_sum_circular_subarray_918;

/**
 * Kadane算法
 */
public class SolutionByAlex {
    public int maxSubarraySumCircular(int[] A) {
        //todo
        //环形数组最大子数组,从左到右最多遍历n-1个数
        int min = Integer.MIN_VALUE;
        int n = A.length;
        int[] f = new int[n];
        f[0] = A[0];
        for(int i=1;i<n;i++){
            //初始化
            f[i] = Integer.MIN_VALUE;
            for(int j=1;j<n;j++){
                int index = i+j;
                if(index >= n){
                    index = index -n;
                }


            }
        }


        return 0;
    }
}

