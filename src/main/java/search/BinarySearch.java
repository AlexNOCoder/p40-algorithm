package search;
/**
   * @author luoyuntian
   * @date 2020-08-22 17:17
   * @description 二分查找
    * @param
   * @return
   */
public class BinarySearch {
    //队列有序
    public static int biSearch(int[] arr,int a){
        int low = 0;
        int high  = arr.length-1;
        int mid;
        while(low <= high){
            mid = (low+high)/2;
            if(arr[mid] == a){
                return mid;
            }else if(arr[mid] <a){
                //向右查找
                low = mid+1;
            }else {
                //向左查找
                high = mid-1;
            }
        }
        return -1;
    }
}
