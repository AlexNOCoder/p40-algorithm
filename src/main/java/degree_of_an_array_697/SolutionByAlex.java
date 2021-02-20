package degree_of_an_array_697;

import java.util.*;

/**
 * 给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。
 *
 * 在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 *
 */
public class SolutionByAlex {

    public static int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        int maxNums = 1;
        int result =Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            Integer temp = nums[i];
            if(map.containsKey(temp)){
                int[] tempArr = map.get(temp);
                //修改数量
                tempArr[0] += 1;
                maxNums = Math.max(maxNums,tempArr[0]);
                //修改lastIndex
                tempArr[2] = i;
            }else {
                int[] newArr = new int[3];
                //数量
                newArr[0] = 1;
                //起始位置
                newArr[1] = i;
                //结束位置
                newArr[2] = i;
                map.put(temp,newArr);
            }
        }
        Set<Integer> sets = map.keySet();
        for(Integer i:sets){
            int[] tempArr = map.get(i);
            if(tempArr[0] == maxNums){
                result = Math.min(result,tempArr[2]-tempArr[1]+1);
            }
        }
        return result;

//        Arrays.sort(nums);
//        int maxLength = 0;
//        for(int i=0,j=0;j< nums.length;){
//            if(nums[j] == nums[i]){
//                j++;
//            }else {
//                maxLength = Math.max(maxLength,j-i);
//                i=j;
//            }
//        }
//        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = {47,47,72,47,72,47,79,47,12,92,13,47,47,83,33,15,18,47,47,47,47,64,47,65,47,47,47,47,70,47,47,55,47,15,60,47,47,47,47,47,46,30,58,59,47,47,47,47,47,90,64,37,20,47,100,84,47,47,47,47,47,89,47,36,47,60,47,18,47,34,47,47,47,47,47,22,47,54,30,11,47,47,86,47,55,40,49,34,19,67,16,47,36,47,41,19,80,47,47,27};
        System.out.println(Arrays.toString(arr));
        System.out.println(findShortestSubArray(arr));
    }
}


