package degree_of_an_array_697;

import java.util.Arrays;

/**
 * 给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。
 *
 * 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 *
 */
public class SolutionByAlex {

    public int findShortestSubArray(int[] nums) {
        Arrays.sort(nums);
        return 1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 1};
        System.out.println(Arrays.toString(arr));;
    }
}


