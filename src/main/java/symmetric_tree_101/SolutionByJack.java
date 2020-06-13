package symmetric_tree_101;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: p40-algorithm
 * @description:
 * @author: lijie
 * @create: 2020-06-13 20:51
 */
public class SolutionByJack {
    public boolean isSymmetric(TreeNode root){
        if (root == null){
            return false;
        }
        return check(root, root);
    }

    public boolean check(TreeNode p, TreeNode q){
        if (p == null && q == null){
            return true;
        }
        if (p == null || q == null){
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }
}
