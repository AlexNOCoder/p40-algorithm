package permutations_46;

import java.util.LinkedList;
import java.util.List;

public class SolutionByAlex {
    List<List<Integer>> res = new LinkedList<List<Integer>>();
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<Integer>();
        trackBack(nums,track);
        return res;
    }
    public void trackBack(int[] nums,LinkedList<Integer> track){
        if(track.size() == nums.length){
            res.add(new LinkedList<>(track));
            return;
        }
        for(int i=0;i< nums.length;i++){
            if(track.contains(nums[i])){
                continue;
            }
            track.add(nums[i]);
            trackBack(nums,track);
            track.removeLast();
        }
    }
}
