package all_possible_full_binary_trees_894;

import common.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class SolutionByAlex {

    List<TreeNode>[] mome;

    public List<TreeNode> allPossibleFBT(int n) {
        if (n % 2 == 0) {
            return new LinkedList<>();
        }
        mome = new LinkedList[n + 1];
        return dfs(n);

    }

    public List<TreeNode> dfs(int n) {
        List<TreeNode> res = new LinkedList<>();
        if (n == 1) {
            res.add(new TreeNode(0));
            return res;
        }
        if (mome[n] != null) {
            return mome[n];
        }
        for (int i = 1; i < n; i += 2) {
            int j = n - i - 1;
            List<TreeNode> leftSubTrees = dfs(i);
            List<TreeNode> rightSubTrees = dfs(j);
            for (int m = 0; m < leftSubTrees.size(); m++) {
                for (int k = 0; k < rightSubTrees.size(); k++) {
                    TreeNode root = new TreeNode(0);
                    root.left = leftSubTrees.get(m);
                    root.right = rightSubTrees.get(k);
                    res.add(root);
                }
            }
        }
        mome[n] = res;
        return res;
    }
}

