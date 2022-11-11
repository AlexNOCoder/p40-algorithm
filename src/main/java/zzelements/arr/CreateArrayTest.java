package zzelements.arr;

/**
 * @program: p40-algorithm
 * @description: 创建数组测试
 * @author: lijie
 * @create: 2022-11-07 22:02
 */
public class CreateArrayTest {

    public static void main(String[] args){

        //新建数组
        int[] nums = {-1,0,3,5,9,12};

        //二分搜索
        Search.binarySearch(nums, 9);

        //删除元素
        int[] nums1 = {0,1,2,3,3,0,4,2};
        Search.removeElement(nums1, 2);

        //有序数组的平方
        int[] nums2 = {-4,-1,0,3,10};
        Search.sortedSqueues(nums2);

        //长度最小的子数组
        int[] nums3 = {2,3,1,2,4,3};
        Search.minSubArrayLen(7, nums3);

        //螺旋矩阵
        Search.generateMatrix(3);

        //搜索插入位置 暴力解法
        int[] nums4 = {1,3,5,6};
        Search.searchInsert(nums4, 5);

        //搜索插入位置 二分法
        Search.searchInsertTow(nums4, 0);

        //在排序数组中查找元素的第一个和最后一个位置
        int[] nums5 = {5,7,7,8,8,8,10};
        Search.searchRange(nums5, 8);

        //X的平方根
        Search.mySqrt(8);

        //有效的完全平方根
        Search.isPerfectSquare(8);

        //删除有序数组中的重复项
        int[] nums6 = {0,0,1,1,1,2,2,3,3,4};
        Search.removeDuplicates(nums6);

        //零移动
        int[] nums7 = {0,1,0,3,12};
        Search.mozeZeros(nums7);

    }

    //测试
    public static void testArray(int[] nums){


    }
}
