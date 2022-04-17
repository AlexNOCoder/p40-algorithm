package increasing_order_search_tree_897;


import common.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class SolutionByAlex {
//    给你一棵二叉搜索树的root，
//    请你 按中序遍历 将其重新排列为一棵递增顺序搜索树，
//    使树中最左边的节点成为树的根节点，
//    并且每个节点没有左子节点，只有一个右子节点。

    List<TreeNode> list = new LinkedList<>();

    public TreeNode increasingBST(TreeNode root) {
        inOrder(root);
        TreeNode head = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            head.right = list.get(i);
            head.left = null;
            head = list.get(i);
        }
        return list.get(0);
    }

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        list.add(new TreeNode(root.val));
        inOrder(root.right);
    }
}
