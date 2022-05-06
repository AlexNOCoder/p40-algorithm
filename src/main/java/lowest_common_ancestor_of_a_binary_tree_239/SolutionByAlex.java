package lowest_common_ancestor_of_a_binary_tree_239;

import common.TreeNode;

public class SolutionByAlex {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        if(root == p || root == q){
            return root;
        }
        // 找到左右孩子
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        // 如果都没有找到
        if(left == null && right == null){
            return null;
        }
        // 如果都找到
        if(left != null && right != null){
            return root;
        }
        // 如果有一个找到
        return left == null ? right: left;
    }
}
