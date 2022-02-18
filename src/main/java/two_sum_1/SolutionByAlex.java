package two_sum_1;

import java.util.Arrays;

public class SolutionByAlex {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i] + nums[j] == target ){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return null;
    }

    // faster!
    public static int[] twoSum2(int[] nums, int target) {
        int [] result = new int[2];
        int [] need = new int[nums.length];
        for (int i=0;i<nums.length;i++){
            need[i] = target- nums[i];
        }
        Arrays.sort(nums);
        Arrays.sort(need);
        for(int j=0;j<nums.length;j++){
            int num1Index = findIndex(nums,need[j]);
            if(num1Index >= 0){
                int num2Index = findIndex(nums,num1Index+1, nums.length ,target - need[j]);
                if(num2Index >=0 && num1Index != num2Index){
                    result[0] = Math.min(num1Index,num2Index);
                    result[1] = Math.max(num1Index,num2Index);
                    return result;
                }
            }
        }
        return result;
    }

    public static int findIndex(int [] arr,int target){
       return findIndex(arr,0,arr.length,target);
    }

    public static int findIndex(int[] arr,int start ,int end,int target){
        for(int i=start;i<end;i++){
            if(arr[i] == target){
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int nums[] = {3,2,3};
        int target = 6;

        int[] result = twoSum2(nums, target);
        Arrays.stream(result).forEach(a -> System.out.println(a));
    }


}
