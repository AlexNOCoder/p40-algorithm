package root_equals_sum_of_children_2236;

import common.TreeNode;

public class SolutionByAlex {
//    给你一个 二叉树 的根结点root，该二叉树由恰好3个结点组成：根结点、左子结点和右子结点。
//    如果根结点值等于两个子结点值之和，返回true，否则返回false 。

    public boolean checkTree(TreeNode root) {

        return root.val==(root.left.val+root.right.val);
    }
}
