package diameter_of_binary_tree_543;

import common.TreeNode;

public class SolutionByAlex {
    //给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
    int ans = 1;
    public int diameterOfBinaryTree(TreeNode root) {
        findMaxPath(root);
        // 路径-1位直径
        return ans-1;
    }

    // 寻找最大路径
    public int findMaxPath(TreeNode root){
        if(root == null ){
            return 0;
        }
        int ll = findMaxPath(root.left);
        int lr = findMaxPath(root.right);
        ans = Math.max(ll+lr+1,ans);
        return Math.max(ll,lr)+1;
    }

}
