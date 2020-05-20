package convert_BST_to_greater_tree_538;

import common.TreeNode;


public class SolutionByAlex {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(13);
        convertBST(root);

    }
    public static int sum;
    public static TreeNode convertBST(TreeNode root) {
        if(root != null){
            convertBST(root.right);
            root.val = root.val +sum;
            sum = root.val;
            convertBST(root.left);
        }
        return null;
    }



}
