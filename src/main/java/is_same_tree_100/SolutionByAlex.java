package is_same_tree_100;

import common.TreeNode;

public class SolutionByAlex {

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        // 递归出口
        if(p == null ||  q == null){
            if(p == q){
                return true;
            }
            return false;
        }
        if(p.val != q.val){
            return false;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }



}
