package maximum_product_subarray_152;

public class SolutionByAlex {
    public static int maxProduct(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int tempMax = 1;
        int tempMin = 1;
        for(int i=0;i<n;i++){
            if(nums[i] < 0){
                //如果i位置为负数，最大与最小交互
                int temp = tempMax;
                tempMax =tempMin;
                tempMin = temp;
            }
            //前面最大值乘i位置值 与 i位置值 比较
            tempMax = Math.max(tempMax*nums[i],nums[i]);
            tempMin = Math.min(tempMin*nums[i],nums[i]);

            max = Math.max(max,tempMax);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,-2,4};
        System.out.println(maxProduct(arr));
    }
}

