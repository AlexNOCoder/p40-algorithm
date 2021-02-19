package degree_of_an_array_697;

import java.util.Arrays;

/**
 * 给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。
 *
 * 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 *
 */
public class SolutionByAlex {

    public static int findShortestSubArray(int[] nums) {
        Arrays.sort(nums);
        int maxLength = 0;
        for(int i=0,j=0;j< nums.length;){
            if(nums[j] == nums[i]){
                j++;
            }else {
                maxLength = Math.max(maxLength,j-i);
                i=j;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 1};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(findShortestSubArray(arr));
    }
}


