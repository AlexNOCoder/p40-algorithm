package convert_BST_to_greater_tree_538;

import common.TreeNode;

import java.util.*;


public class SolutionByAlex {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(4);
        convertBST(root);

    }

    public static TreeNode convertBST(TreeNode root) {
        inOrder(root);
        return root;
    }

    public static void inOrder(TreeNode root){
        if(root.left != null){
            inOrder(root.left);
            root.val = root.right.val + root.val;
        }




        if(root.right != null){
            root.left.val = root.left.val + root.val;
            inOrder(root.right);
        }

    }

}
