package common.other;

/**
 * @author luoyuntian
 * @program: p40-algorithm
 * @description: 二分查找递归实现
 * @date 2022-03-02 06:59:20
 */
public class BinarySearchInternally {
    public int binarySearch(int[] nums,int t){
        return binarySearchInternally(nums,0,nums.length-1,t);
    }
    private int binarySearchInternally(int[] a,int low,int high,int value){
        if(low > high){
            return -1;
        }
        int mid = (low + high) / 2;
        // 等于半数
        if(value == a[mid]){
            return mid;
        }
        // 半数以内
        else if(value < a[mid]){
            return binarySearchInternally(a,low,mid-1,value);
        }
        // 大于半数
        else{
            return binarySearchInternally(a,mid+1,high,value);
        }

    }

}
