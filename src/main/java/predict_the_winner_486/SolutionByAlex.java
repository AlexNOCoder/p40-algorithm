package predict_the_winner_486;

public class SolutionByAlex {
    //每个玩家为了使自己的分数最大，会选首位中数字最大的值
    public static boolean PredictTheWinner(int[] nums) {
        if(nums.length == 1){
            return true;
        }
        int count1 = 0;
        int count2 = 0;
        for(int i=0,j=nums.length-1,k=1;i < j;k++){
            boolean flag = nums[i] >= nums[j];
            if(k %2 ==1){
                //玩家1选择
                int choose1 = nums[i] >= nums[j] ? nums[i] : nums[j];
                count1 += choose1;
            }else {
                //玩家2选择
                int choose2 = nums[i] >= nums[j] ? nums[i] : nums[j];
                count2 += choose2;
            }
            if(flag){
                i++;
            }else {
                j--;
            }
        }

        return count1 > count2 ? true : false;
    }

    public static void main(String[] args) {
        int[] test1 = {1,5,233,7};
        System.out.println(PredictTheWinner(test1));
    }
}
