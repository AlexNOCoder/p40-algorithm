package count_complete_tree_nodes_222;

import common.TreeNode;

public class SolutionByAlex {

    // 遍历方式
    int count = 0;
    public int countNodes(TreeNode root) {
        preOrder(root);
        return count;
    }

    public void preOrder(TreeNode root){
        if(root == null){
            return;
        }
        count++;
        preOrder(root.left);
        preOrder(root.right);
    }


    // 分解子问题方式
    public int countNodes2(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = countNodes2(root.left);
        int right = countNodes2(root.right);
        return left+right+1;
    }
}


