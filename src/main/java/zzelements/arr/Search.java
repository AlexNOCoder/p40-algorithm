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
     * 根据区间的定义来判断边界。循环不变量，
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

    /**
     *螺旋矩阵
     *
     * @param n
     * @return
     */
     public static int[][] generateMatrix(int n){
         int loop = 0; //控制循环次数
         int[][] res = new int[n][n];//定义一个二维数组
         int start = 0; //每次循环的开始点（start,start）
         int count = 1; //定义填充数字
         int i,j;

         while(loop ++ < n/2){
             //模拟上侧从左到右
             for (j = start; j < n - loop; j ++){
                 res[start][j] = count ++;
             }
             //模拟右侧从上到下
             for (i = start; i < n - loop; i ++){
                 res[i][j] = count ++;
             }
             //模拟下侧从右到左
             for (;j >= loop; j--){
                 res[i][j] = count ++;
             }
             //模拟左侧从下到上
             for (;i >= loop; i --){
                 res[i][j] = count ++;
             }
             start ++;
         }
         if (n % 2 == 1){
             res[start][start] = count;
         }
         System.out.println("螺旋矩阵: ");
         for (int x = 0; x < res.length; x ++){
             for (int y = 0; y < res[x].length; y ++){
                 System.out.print(res[x][y]+"  ");
             }
             System.out.println();
         }
         return res;
     }

    /**
     *搜索插入位置35
     * 以下四种情况：
     * 1.目标值在数组所有元素之前
     * 2.目标值等于数组中的某一个元素
     * 3.目标值插入数组中的位置
     * 4.目标值在所有元素之后
     */
    public static int searchInsert(int[] nums, int target){
        //暴力解法，遍历一次，时间复杂度O(N)
        for (int i = 0; i < nums.length; i ++){
            if (nums[i] >= target){
                System.out.println("搜索插入位置：" + i);
                return i;
            }
        }
        System.out.println("搜索插入位置：" + nums.length);
        return nums.length;
    }

    //搜索插入位置 二分法
    public static int searchInsertTow(int[] nums, int target){
        int n = nums.length;

        int low = 0;
        int high = n -1;

        while (low <= high){
            int mid = low + (high - low)/2;
            if (nums[mid] > target){
                high = mid - 1;
            }else if (nums[mid] < target){
                low = mid + 1;
            }else {
                System.out.println("搜索插入位置：" + mid);
                return mid;
            }
        }
        System.out.println("搜索插入位置：" + (high + 1));
        return high + 1;
    }

    //在排序数组中查找元素的第一个和最后一个位置
    /**
     * 左右边界，有如下三种情况：
     * 1.target在数组范围的左边或者右边，例如数组{3，4，5}，target为2或者6。此时返回{-1，-1}
     * 2.target在数组范围中，例如{3，6，7}，target为5，此时返回{-1，-1}
     * 3.target在数组范围中，且数组中存在target，如{3，6，7}，target为6，返回{1，1}
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange(int[] nums,int target){
        int leftBorder = getLeftBorder(nums,target);
        int rightBorder = getRightBorder(nums,target);
        //情况一
        if (leftBorder == -2 || rightBorder == -2) {
            System.out.println("情况一:" + "{-1, -1}");
            return new int[]{-1,-1};
        }
        //情况三
        if (rightBorder - leftBorder > 1){
            System.out.println("情况三:" + (leftBorder + 1) +","+ (rightBorder - 1));
            return new int[]{leftBorder + 1, rightBorder - 1};}
        //情况二
        System.out.println("情况二:" + "{-1, -1}");
        return new int[]{-1, -1};
    }

    //将区间划分为[l,mid -1]和[mid,r]
    static int getRightBorder(int[] nums, int target){
        int left = 0;
        int right = nums.length -1;//定义左右边界[left,right]
        int rightBorder = -2;//记录一哈rightBorder没有赋值的情况
        while(left <= right){
            int middle = left + (right - left)/2;
            if (nums[middle] > target){
                right = middle - 1;
            }else {
                left = middle + 1;
                rightBorder = left;
            }
        }
        return rightBorder;
    }

    static int getLeftBorder(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        int leftBorder = -2;
        while (left <= right){
            int middle = left + (right - left)/2;
            if (nums[middle] >= target){
                right = middle - 1;
                leftBorder = right;
            }else {
                left = middle + 1;
            }
        }
        return leftBorder;
    }

    //X的平方根
    public static int mySqrt(int x){
        int l = 0, r = x, ans = -1;
        while (l <= r){
            int mid = l + (r-l)/2;
            if ((long)mid * mid <= x){
                ans = mid;
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        System.out.println("x的平方根：" + ans);
        return ans;
    }

    //
}
