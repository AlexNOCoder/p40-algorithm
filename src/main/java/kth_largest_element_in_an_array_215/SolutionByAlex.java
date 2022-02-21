package kth_largest_element_in_an_array_215;

//插入排序，然后取k-1
public class SolutionByAlex {

    public static void main(String[] args) {
        int[] test ={3,2,3,1,2,4,5,5,6};
        int k=4;
        System.out.println(findKthLargest(test,k));
    }

    public static int findKthLargest(int[] nums, int k) {

        for(int i=0;i<k;i++){
            int max = nums[i];
            int flag = 0;
            for(int j=i;j<nums.length;j++){
                if(max <= nums[j]){
                    max = nums[j];
                    flag = j;
                }
            }
            swap(nums,i,flag);
        }
        return nums[k-1];
    }

    public static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public  int findKthLargest2(int[] nums, int k){
        return quickSelect(nums,0,nums.length-1,k);
    }

    public int quickSelect(int[]nums, int low,int high,int k){
        // 随机取一个基准值，这里取最后一个数作为基准值
        int pivot = low;
        // 将比基准值小的数放在左边，比基准值大的数放在右边
        for(int j = low;j < high;j++){
            if(nums[j] <= nums[high]){
                swap(nums,pivot++,j);
            }
        }
        swap(nums,pivot,high);
        int count = high - pivot +1;
        // 判断基准值位置是不是第k大的元素
        // 如果是，返回结果
        if(count == k) {
            return nums[pivot];
        }
        // 如果基准值过小，向右搜索
        if(count >k) {
            return quickSelect(nums,pivot+1,high,k);
        }
        // 如果基准值过大，向左搜索
        return quickSelect(nums,low,pivot-1,k-count);
    }
}
