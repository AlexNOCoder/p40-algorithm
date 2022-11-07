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
        testArray(nums);

    }

    //测试
    public static void testArray(int[] nums){

        //二分搜索
        Search.binarySearch(nums, 9);
    }
}
