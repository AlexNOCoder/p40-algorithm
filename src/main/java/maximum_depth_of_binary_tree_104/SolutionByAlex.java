package maximum_depth_of_binary_tree_104;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SolutionByAlex {
    // 遍历的解法
    int depth =0;
    int res =0;
    public int maxDepth(TreeNode root) {
        dfs(root);
        return res;
    }
    public void dfs(TreeNode root){
        if(root == null){
            res = Math.max(res,depth);
            return;
        }
        depth++;
        dfs(root.left);
        dfs(root.right);
        depth--;
    }

    // 分解子问题的解法
//    public int maxDepth(TreeNode root) {
//        if(root == null){
//            return 0;
//        }
//        int left = maxDepth(root.left);
//        int right = maxDepth(root.right);
//
//        return Math.max(left,right)+1;
//    }
}

