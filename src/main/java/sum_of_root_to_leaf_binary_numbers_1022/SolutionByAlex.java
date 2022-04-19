package sum_of_root_to_leaf_binary_numbers_1022;

import common.TreeNode;


public class SolutionByAlex {
    int ans;

    public int sumRootToLeaf(TreeNode root) {
        ans = 0;
        preOder(root, 0);
        return ans;
    }

    // 前序遍历
    public void preOder(TreeNode root, int prev) {
        // 若根节点为空直接返回
        if (root == null)
            return;
        // 二进制求和法
        prev = prev * 2 + root.val;
        // 若该节点没有左右子树，则得到一条路径的和
        if (root.left == null && root.right == null) {
            ans += prev;
            return;
        }
        // 遍历左右子树节点
        preOder(root.left, prev);
        preOder(root.right, prev);
    }

}
