package common.other;

/**
 * @author luoyuntian
 * @program: p40-algorithm
 * @description: 二分查找非递归实现
 * @date 2022-03-02 06:55:30
 */
public class BinarySearch {
    public static int binarySearch(int[] nums,int t){
        // 低位索引
        int low = 0;
        // 高位索引
        int high = nums.length - 1;
        // 中间索引
        int mid = 0;
        while(low <= high){
            mid = (low + high)/2;
            // 等于半数
            if(t == nums[mid]){
                return mid;
            }
            // 半数以内
            else if(t < nums[mid]){
                high = mid - 1;
            }
            // 大于半数
            else{
                low = mid + 1;
            }
        }
        return -1;

    }

}
