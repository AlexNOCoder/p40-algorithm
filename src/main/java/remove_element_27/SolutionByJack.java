package remove_element_27;

/**
 * @program: p40-algorithm
 * @description: 删除元素
 * @author: lijie
 * @create: 2020-07-03 09:36
 */
public class SolutionByJack {
    public int removeElement(int[] nums, int val){
        int i = 0;
        for (int j = 0; j < nums.length; j ++){
            if (nums[j] != val){
                nums[i] = nums[j];
                i ++;
            }
        }
        return i;
    }

    public int removeElement1(int[] nums, int val){
        int i = 0;
        int n = nums.length;
        while(i < n){
            if (nums[i] == val){
                nums[i] = nums[n - 1];
                //reduce array size by one
                n --;
            }else {
                i ++;
            }
        }
        return n;
    }
}
