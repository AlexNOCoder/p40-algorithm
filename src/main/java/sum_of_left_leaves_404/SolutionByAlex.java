package sum_of_left_leaves_404;

import common.TreeNode;

public class SolutionByAlex {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        int result  = sumOfLeftLeaves(root);
        System.out.println(result);
    }
    //首先要确定递归函数的参数和返回值
    public static int sumOfLeftLeaves(TreeNode root) {
        //确定终止条件
        if(root == null){
            return 0;
        }
        //确定单个递归的逻辑
        int sum = 0;
        if(root.left != null &&root.left.right == null && root.left.left == null) {
            sum = root.left.val;
        }
        int sumOfLeft = sumOfLeftLeaves(root.left);
        int sumOfRight = sumOfLeftLeaves(root.right);
        return sum+sumOfLeft+sumOfRight;
    }
}
