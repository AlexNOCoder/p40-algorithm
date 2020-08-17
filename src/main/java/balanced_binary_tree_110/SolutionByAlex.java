package balanced_binary_tree_110;

import common.TreeNode;


public class SolutionByAlex {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.right = new TreeNode(20);
        root.left = new TreeNode(9);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(high(root));
        System.out.println(isBalanced(root));;
    }


    public static boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        //先根，后左，最后右
        return Math.abs(high(root.left) - high(root.right))<=1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public static int high(TreeNode root){
        if(root == null){
            return 0;
        }else{
            return Math.max(high(root.left), high(root.right))+1;
        }

    }

}
