package permutations_ii_47;

import java.util.*;

public class SolutionByAlex {
    boolean[] vis;
    List<List<Integer>> ans = new LinkedList<List<Integer>>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        LinkedList<Integer> track = new LinkedList<Integer>();
        vis = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, track);
        return ans;
    }

    public void backtrack(int[] nums, LinkedList<Integer> track) {
        if (track.size() == nums.length) {
            ans.add(new LinkedList<Integer>(track));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            // 被访问过
            // 对原数组排序，保证相同的数字都相邻，
            // 然后每次填入的数一定是这个数所在重复数集合中「从左往右第一个未被填过的数字」

            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                continue;
            }
            track.add(nums[i]);
            vis[i] = true;
            backtrack(nums, track);
            vis[i] = false;
            track.removeLast();
        }
    }
}
