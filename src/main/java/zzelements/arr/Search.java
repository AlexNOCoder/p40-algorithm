package zzelements.arr;

/**
 * @program: p40-algorithm
 * @description: 查找
 * @author: lijie
 * @create: 2022-11-07 22:35
 */
public class Search {

    /**
     * 二分查找法
     * 二分查找法是一种在有序数组中查找某一特定元素的搜素算法。从数组的中间元素开始，每次比较都使搜索范围缩小一半。
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearch(int[] nums, int target){
        //在区间【乐翻天，日光合同】中查找元素，左闭右闭
        int left = 0;
        int right = nums.length - 1;

        while (left <= right){
            int mid = left + (right - left)/2;
            if (target == nums[mid]){System.out.println(mid);return mid;}
            else if (target < nums[mid]){right = mid - 1;}
            else if (target > nums[mid]){left = mid + 1;}
        }
        return -1;
    }
}
