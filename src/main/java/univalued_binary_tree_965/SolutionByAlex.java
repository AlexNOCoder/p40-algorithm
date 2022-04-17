package univalued_binary_tree_965;

import common.TreeNode;

public class SolutionByAlex {
//    如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
//    只有给定的树是单值二叉树时，才返回 true；否则返回 false。

    public boolean isUnivalTree(TreeNode root) {
        boolean left_correct = (root.left == null ||
                (root.val == root.left.val && isUnivalTree(root.left)));
        boolean right_correct = (root.right == null ||
                (root.val == root.right.val && isUnivalTree(root.right)));
        return left_correct && right_correct;
    }
}
