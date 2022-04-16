package binary_tree_tilt_563;


import common.TreeNode;

public class SolutionByAlex {
//    给你一个二叉树的根节点 root ，计算并返回 整个树 的坡度 。
//    一个树的 节点的坡度 定义即为，该节点左子树的节点之和和右子树节点之和的 差的绝对值 。如果没有左子树的话，左子树的节点之和为 0 ；没有右子树的话也是一样。空结点的坡度是 0 。
//    整个树 的坡度就是其所有节点的坡度之和。

    int ans = 0;
    public int findTilt(TreeNode root) {
        findChildCount(root);
        return ans;
    }

    public int findChildCount(TreeNode root){
        if(root == null){
            return 0;
        }
        // 计算左边总数
        int leftTilt =  findChildCount(root.left);
        // 计算右边总数
        int rightTile = findChildCount(root.right);
        // 累计坡度
        ans += Math.abs(leftTilt-rightTile);
        // 返回该节点总数
        return leftTilt+rightTile+root.val;
    }

}
