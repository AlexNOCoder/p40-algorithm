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
}
