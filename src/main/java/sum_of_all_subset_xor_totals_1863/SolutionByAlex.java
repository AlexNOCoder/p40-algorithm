package sum_of_all_subset_xor_totals_1863;


public class SolutionByAlex {

    int n;
    int res;
    public void dfs(int val,int idx,int [] nums){
        if(idx == n){
            res += val;
            return;
        }
        // 取当前值
        dfs(val^nums[idx],idx+1,nums);
        // 不取当前值
        dfs(val,idx+1,nums);
    }
    public int subsetXORSum(int[] nums) {
        n = nums.length;
        res = 0;
        dfs(0,0,nums);
        return res;
    }
}
