package check_balance_LCCI_04_04;

import common.TreeNode;


public class SolutionByAlex {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(4);
//        System.out.println(getHeightDifference(root));
//        System.out.println(getMaxDeepth(root));
//        System.out.println(isBalanced(root));
//        Integer[] arr = new Integer[]{1,2,2,3,null,null,3,4,null,null,4};

        Integer[] arr = new Integer[]{3,9,20,null,null,15,7};
        isBalanced(root);

    }
    private static boolean flag = true;
    public static boolean isBalanced(TreeNode root) {
        getMaxDeepth(root);
        return flag;
    }

    public static int getMaxDeepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = getMaxDeepth(root.left);
        int right = getMaxDeepth(root.right);
        if(Math.abs(left - right) > 1){
            flag = false;
        }
        return Math.max(left,right)+1;

    }
}
