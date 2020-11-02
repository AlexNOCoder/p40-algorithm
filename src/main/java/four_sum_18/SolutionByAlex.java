package four_sum_18;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionByAlex {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        //如果输入长度小于4
        if(length < 4){
            return null;
        }
        Arrays.sort(nums);
        //如果最小的四个数加起来大于target，或则最大四个数加起来小于target，返回null
        if(nums[0]+nums[1]+nums[2]+nums[3] > target || nums[length-1]+nums[length-2]+nums[length-3]+nums[length-4]<target){
            return null;
        }
        //从最小的值开始遍历,并且不取前面已经遍历的值
        for(int i=0;i<length;i++){
            //处理nums[i]太大的情况,如果target已经大于target，再加上不能遍历前面的值，此时可以直接break
            if(nums[i] > target){
                break;
            }
            //处理nums[i]太小的情况，如果nums[i]加上最后三个值都还小于target，就可以直接continue
            if(nums[i]+nums[length-1]+nums[length-2]+nums[length-3] < target){
                continue;
            }
            //正式开始找合适的组合
            for(int j=i+1;j<length-2;j++){
                int right = length-1;
                int left = j+1;
                //查找结束条件，right与left相遇
                while(left < right){
                    if(nums[i] + nums[j]+nums[right]+ nums[left] == target){
                        //如果恰好找到等于目标值
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[right]);
                        temp.add(nums[left]);
                        result.add(temp);
                        //left指针右移,不两边一起移动是因为有可能有重复的数字
                        left++;
                    }else if(nums[i] + nums[j]+nums[right]+ nums[left] < target){
                        //小于目标值，left右移，增大和
                        left++;
                    }else {
                        //大于目标值，right左移，减小和
                        right--;
                    }
                }
            }

        }
        return  result;
    }

    public static void main(String[] args) {

    }
}
