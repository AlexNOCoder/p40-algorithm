package product_of_array_except_self_238;


public class SolutionByAlex {
    public static void main(String[] args) {
        int[] test = {1,2,3,4};
        productExceptSelf(test);
    }
    public static  int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        for(int i = 0;i<nums.length;i++){
            if(i == 0){
                left[i] = nums[i];
                right[nums.length-1-i] = nums[nums.length-1];
            }else{
                left[i] = nums[i] * left[i-1];
                right[nums.length-1-i] = nums[nums.length-1-i] * right[nums.length-i];
            }
        }
        for(int j = 1;j<nums.length-1;j++){
            nums[j] = left[j-1] * right[j+1];
        }
        nums[0] = right[1];
        nums[nums.length-1] = left[nums.length-2];
        return nums;
    }
}
