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
     * 第一步分清楚区间，闭还是开，开还是闭。
     * 根据区间的定义来判断边界。
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearch(int[] nums, int target){
        //在区间【乐翻天，日光合同】中查找元素，左闭右闭
        int left = 0;
        int right = nums.length - 1;

        //左闭右闭，判断是不是一个合法值。<=
        //在left==right时，区间类还有一个元素要查找。
        while (left <= right){
            int mid = left + (right - left)/2;
            if (target == nums[mid]){System.out.println("二分查找：" + mid);return mid;}
            else if (target < nums[mid]){right = mid - 1;}
            else if (target > nums[mid]){left = mid + 1;}
        }
        return -1;
    }

    /**
     * 删除元素
     * 双指针法：通过一个快指针和慢指针在一个for循环下完成两个for循环的工作。
     * 快指针：用来获取新数组中的元素
     * 慢指针：获取新数组中需要获取的位置
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val){
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast ++){
            //找到了数据，慢指针就会变慢一步，把慢指针对应的数据用快指针找到的值进行覆盖。即把后面的值往前挪。
            if (nums[fast] != val){
                nums[slow] = nums[fast];
                slow ++;
            }
        }
        System.out.println("删除元素：" + slow);
        return slow;
    }
}
