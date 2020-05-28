package target_sum_494;

public class SolutionByAlex {

    int sum;
    public int findTargetSumWays(int[] nums, int S) {
        BFS(nums, S,0,0);
        return sum;
    }

    private void BFS(int[] nums, int s,int temp,int number) {
        if (number == nums.length) {
            if(temp == s){
                sum ++;
            }
            return;

        }
        BFS(nums, s, temp + nums[number], number + 1);
        BFS(nums, s, temp - nums[number], number + 1);
    }

}


