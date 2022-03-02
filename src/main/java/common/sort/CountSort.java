package common.sort;

/**
 * @author luoyuntian
 * @program: p40-algorithm
 * @description: 计数排序
 * 对有限范围的数进行排序
 * @date 2022-03-02 20:30:40
 */
public class CountSort {

    public static int[] countSort(int[] array,int offset){
        int[] nums = new int[array.length];
        for(int i = 0;i< array.length;i++){
            int n = array[i] - offset;
            // 数字自增
            nums[n]++;
        }
        int[] nums2 = new int[array.length];
        // i是计数数组下标，k是新数组下标
        for(int i = 0,k = 0;i < nums.length;i++){
            for(int j = 0;j < nums[i];j++){
                nums2[k++] = i + offset;
            }
        }
        return nums2;
    }

    public static void main(String[] args) {
        int[] scores = {95,94,92,99,95,91,90,93,92,97,96};
        for(int n:countSort(scores,90)){
            System.out.println(n);
        }
    }
}
