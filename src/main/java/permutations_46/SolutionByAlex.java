package permutations_46;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SolutionByAlex {
    public List<List<Integer>> permute(int[] nums) {
        //回溯法：一种通过探索所有可能的候选解来找出所有的解的算法。
        // 如果候选解被确认不是一个解（或者至少不是最后一个解），回溯算法会通过在上一步进行一些变化抛弃该解，即回溯并且再次尝试。
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> output = new ArrayList<>();
        for(int num:nums){
            output.add(num);
        }

        int n = nums.length;
        backtrack(n,output,res,0);
        return res;
    }

    public void backtrack(int n,List<Integer> output,List<List<Integer>> res,int first){
        //结束条件，所有数字都已经选完
        if(first == n){
            res.add(new ArrayList<>(output));
        }

        for(int i = first;i<n;i++){
            //维护动态数组
            Collections.swap(output,first,i);

            //继续填下一个数
            backtrack(n,output,res,first+1);
            //撤销
            Collections.swap(output,first,i);
        }
    }
}
