package remove_duplicates_from_sorted_array_26;

public class SolutionByAlex {
    public static void main(String[] args) {
//        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int[] nums = {1,2,2};
        System.out.println(removeDuplicates(nums));;
    }

    public static int removeDuplicates(int[] nums) {
        int result =  nums.length;
        for(int i=0,j=1;j<nums.length;){
            while(nums[i] == nums[j]){
                //结尾有重复情况处理
                if(j == nums.length-1){
                    return i +1;
                }
                j++;
                //有重复，减一
                result--;
            }
            //非重复数字前移
            nums[i+1] = nums[j];
            i++;
            j++;
        }
        return result;
    }
}
