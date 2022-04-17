package leaf_similar_trees_872;


import common.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class SolutionByAlex {
    //    请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new LinkedList<>();
        List<Integer> list2 = new LinkedList<>();
        leafList(root1, list1);
        leafList(root2, list2);
        if (list1.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list1.size(); i++) {
            if (!list1.get(i).equals(list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    private void leafList(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.right == null && root.left == null) {
            list.add(root.val);
        }
        leafList(root.left, list);
        leafList(root.right, list);

    }
}
