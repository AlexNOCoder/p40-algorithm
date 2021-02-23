package maximum_sum_circular_subarray_918;

/**
 * Kadane算法
 */
public class SolutionByAlex {
    public static int maxSubarraySumCircular(int[] A) {
        //两次kadane算法
        //两种情况：一是最大子数组没有使用到环形，直接使用kadane算法求解
        //二是最大子数组使用到了环形，那么A数组的第一个元素和最后一个元素肯定都包含在内
        //也就是说我们转换成求[1,n-2]位置上的最小子数组，然后总数减去最小子数组就是包含环形的最大子数组的值

        int currMax = Integer.MIN_VALUE,currMin = 0,max = Integer.MIN_VALUE,min = 0,sum = 0;
        int n = A.length;

        for(int i=0;i<n;i++){
            sum += A[i];
            if(currMax < 0 ){
                currMax =0;
            }
            currMax += A[i];
            if(i > 0 && i < n-1){
                if(currMin > 0) {
                    currMin = 0;
                }
                currMin += A[i];

                min = Math.min(min,currMin);
            }
            max = Math.max(max,currMax);
        }
        return Math.max(max,sum-min);
    }

    public static void main(String[] args) {
        int[] arr1 = {1,-2,3,-2};
        int[] arr2 = {5,-3,5};
        int[] arr3 = {3,-1,2,-1};
        int[] arr4 = {-2,-3,-1};
        int[] arr5 = {2,-2,2,7,8,0};
        int[] arr6 = {-2,4,-5,4,-5,9,4};
                System.out.println(maxSubarraySumCircular(arr1));
        System.out.println(maxSubarraySumCircular(arr2));
        System.out.println(maxSubarraySumCircular(arr3));
        System.out.println(maxSubarraySumCircular(arr4));
        System.out.println(maxSubarraySumCircular(arr5));
        System.out.println(maxSubarraySumCircular(arr6));

    }
}

