package combination_sum_39;

import java.util.LinkedList;
import java.util.List;

public class SolutionByAlex {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates.length == 0){
            return res;
        }
        LinkedList<Integer> track = new LinkedList<Integer>();
        backtrack(candidates,target,0,track);
        return res;
    }
    public void backtrack(int[] candidates, int target,int start,LinkedList<Integer> track){
        if(sumOfList(track) == target){
            res.add(new LinkedList<>(track));
            return;
        }
        if(sumOfList(track) > target){
            return;
        }
        for(int i =start;i<candidates.length;i++){
            track.add(candidates[i]);
            backtrack(candidates,target,i,track);
            track.removeLast();
        }
    }

    public int sumOfList(List<Integer> list){
        int count = 0;
        for(Integer i:list){
            count+= i;
        }
        return count;
    }
}
