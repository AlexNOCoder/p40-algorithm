package add_two_numbers_2;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: p40-algorithm
 * @description:
 * @author: lijie
 * @create: 2020-06-13 23:05
 */
public class SolutionByJack {
    public int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i ++){
            int complement = target - nums[i];
            if (map.containsKey(complement)){
                return new int[] {map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public void test(){
    }
}
