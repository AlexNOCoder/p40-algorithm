package combination_sum_ii_40;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SolutionByAlex {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len = candidates.length;
        if (len == 0) {
            return res;
        }
        Arrays.sort(candidates);
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(candidates, len, 0, target, track);
        return res;
    }

    private void backtrack(int[] candidates, int len, int start, int target, LinkedList<Integer> track) {
        if (target == 0) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = start; i < len; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            track.add(candidates[i]);
            backtrack(candidates, len, i + 1, target - candidates[i], track);
            track.removeLast();

        }
    }
}
