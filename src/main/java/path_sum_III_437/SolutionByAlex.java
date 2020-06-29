package path_sum_III_437;


import common.TreeNode;

//双层递归，第一层遍历所有节点，第二层遍历该节点的所有使条件成立的可能
public class SolutionByAlex {

    private int count=0;
    public int pathSum(TreeNode root, int sum) {
        if(root == null){
            return 0;
        }
        getPathSumNumber(root,sum);
        pathSum(root.left,sum);
        pathSum(root.right,sum);
        return count;
    }

    public void getPathSumNumber(TreeNode root,int sum){
        if(root == null){
            return;
        }
        sum -= root.val;
        if(sum == 0){
            count++;
        }
        getPathSumNumber(root.left,sum);
        getPathSumNumber(root.right,sum);

    }
}
