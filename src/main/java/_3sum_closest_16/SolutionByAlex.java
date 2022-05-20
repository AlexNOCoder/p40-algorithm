package _3sum_closest_16;


import java.util.Arrays;

public class SolutionByAlex {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int delta = Integer.MAX_VALUE;
        for(int i=0;i<nums.length-2;i++){
            int sum = nums[i] + twoSumClosest(nums,i+1,target-nums[i]);
            if(Math.abs(delta) > Math.abs(target - sum)){
                delta = target - sum;
            }
        }
        return target -delta;
    }

    int twoSumClosest(int[] nums, int start, int target) {
      int left = start;
      int right = nums.length-1;
      int delta = Integer.MAX_VALUE;
      while(left < right){
          int sum = nums[left] + nums[right];
          if(Math.abs(delta) > Math.abs(target- sum)){
              delta = target - sum;
          }
          if(sum > target){
              right --;
          }else{
              left ++;
          }
      }
      return target - delta;
    }
}

