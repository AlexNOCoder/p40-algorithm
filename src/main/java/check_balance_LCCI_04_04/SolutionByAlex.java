package check_balance_LCCI_04_04;

import common.TreeNode;


public class SolutionByAlex {


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
