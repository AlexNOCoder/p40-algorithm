package symmetric_tree_101;


import common.TreeNode;

public class SolutionByAlex {

    //左子树的右子树与右子树的左子树对称
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return help(root.right,root.left);
    }

    public boolean help(TreeNode t1,TreeNode t2){
        if(t1 == null && t2 == null){
            return true;
        }else if(t1 == null || t2 == null){
            return false;
        }else if(t1.val != t2.val){
            return false;
        }else{
            return help(t1.left,t2.right) && help(t1.right,t2.left);
        }

    }


}


