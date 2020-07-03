package deletes_duplicates_insorted_array_26;

/**
 * @program: p40-algorithm
 * @description: 删除排序数组中的重复项
 * @author: lijie
 * @create: 2020-07-02 14:39
 */
public class SolutionByJack {
    public int removeDuplicates(int[] nums){
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 0; j < nums.length; j ++){
            if (nums[j] != nums[i]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

}
