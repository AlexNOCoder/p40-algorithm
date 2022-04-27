package binary_tree_maximum_path_sum_124;

import common.TreeNode;

public class SolutionByAlex {

    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }
    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = Math.max(0,dfs(root.left));
        int right = Math.max(0,dfs(root.right));
        res = Math.max(res,left+right+root.val);
        return Math.max(left,right)+root.val;
    }
}
