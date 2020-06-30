package minimum_depth_of_binary_tree_111;

import common.TreeNode;

import java.util.*;

public class SolutionByAlex {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.left.left = new TreeNode(5);
        System.out.println(minDepth(root));
    }

    public static int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        int path = 0;
        while(!queue.isEmpty()){
            path++;
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(node.left == null && node.right == null){
                    return path;
                }
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }

            }
        }
        return path;
    }

}
