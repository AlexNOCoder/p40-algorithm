package minimum_distance_between_bst_nodes_783;

import common.TreeNode;

import java.util.PriorityQueue;

public class SolutionByAlex {
//    给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
//    差值是一个正数，其数值等于两值之差的绝对值。
    PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
    public int minDiffInBST(TreeNode root) {
        preOrder(root);
        int minDiff = Integer.MAX_VALUE;
        int preNum = queue.poll();
        while(!queue.isEmpty()){
           int currentNum = queue.poll();
           minDiff = Math.min(minDiff,Math.abs(preNum-currentNum));
           preNum = currentNum;
        }
        return minDiff;
    }
    public void preOrder(TreeNode root){
        if(root == null){
            return;
        }
        queue.offer(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
}
