package range_sum_of_bst_938;


import common.TreeNode;

public class SolutionByAlex {
    //    给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
    int sum = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        inOrder(root, low, high);
        return sum;
    }

    public void inOrder(TreeNode root, int low, int high) {
        if (root == null) {
            return;
        }
        inOrder(root.left, low, high);
        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }
        inOrder(root.right, low, high);
    }

}
