package path_sum_112;


import common.TreeNode;

public class SolutionByAlex {
    private int number = 0;
    public boolean hasPathSum(TreeNode root, int sum) {
        pathSum(root,sum);
        return number > 0 ? true:false;
    }
    public void pathSum(TreeNode root, int sum){
        if(root == null ){
            return;
        }
        sum -= root.val;
        if(root.left == null && root.right == null && sum ==0){
            number++;
        }
        hasPathSum(root.left,sum);
        hasPathSum(root.right,sum);
    }
}
