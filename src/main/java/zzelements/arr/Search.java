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


    /**
     * 有序数组的平方
     */
    public static int[] sortedSqueues(int[] nums){
        int[] result = new int[nums.length];
        int k = nums.length - 1;
        for (int i = 0,j = nums.length - 1; i <= j;){
            if (nums[i]*nums[i] > nums[j]*nums[j]){
                result[k--] = nums[i]*nums[i];
                i ++;
            }else{
                result[k--] = nums[j]*nums[j];
                j --;
            }
        }
        System.out.println("有序数组的平方：" + result);
        return result;
    }

    /**
     * 长度最小的子数组209
     * 使用滑动窗口算法，所谓滑动窗口，就是不断的调节子序列的起始位置和终止位置，从而得出我们想要的结果。
     * 如果只用一个for循环那么应该表示滑动窗口的起始位置
     * 使用滑动窗口主要确定三点：
     * 1.窗口内是上面？   ---就是其 >=s 的长度最小的子数组。
     * 2.如何移动窗口的起始位置？    ---如果当前窗口的值大于s，就向前移动，就是缩小窗口。
     * 3.如何移动窗口的结束位置？    ---窗口的结束位置就是遍历数组的指针，也就是for循环里面的索引。
     * @param target
     * @param nums
     * @return
     */
     public static int minSubArrayLen(int target, int[] nums){
         int left = 0;//滑动窗口起始位置
         int sum = 0;//滑动窗口数值之和
         int result = Integer.MAX_VALUE;//滑动窗口长度
         for (int right = 0; right < nums.length; right  ++){//right是滑动窗口的结束位置
             sum += nums[right];
             while(sum >= target){//这里使用while，每次更新left（起始位置），并不断比较子序列是否符合条件。
                 result = Math.min(result, right - left + 1);//right-left+1是指子序列的长度
                 sum -= nums[left ++];//不断变更left，子序列的起始位置。
             }
         }
         result = result == Integer.MAX_VALUE ? 0 : result;//如果result没有被赋值，就返回0.
         System.out.println("长度最小的子数组：" + result);
         return result;
     }
}
