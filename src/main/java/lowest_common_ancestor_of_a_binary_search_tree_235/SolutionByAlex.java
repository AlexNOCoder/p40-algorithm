package lowest_common_ancestor_of_a_binary_search_tree_235;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SolutionByAlex {
    // 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Stack<TreeNode> stack = new Stack<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            // 取出节点
            TreeNode temp = queue.poll();
            // 判断节点
            if(findNode(temp,p) && findNode(temp,q) ){
                stack.push(temp);
            }
            // 把该节点的子节点放入queue
            if(temp.left != null){
                queue.offer(temp.left);
            }

            if(temp.right != null){
                queue.offer(temp.right);
            }

        }
        return stack.peek();
    }

    // root是否是p节点的祖先
    public boolean findNode(TreeNode root, TreeNode p){
        if(root == null){
            return false;
        }
        if(root.val == p.val){
            return true;
        }
        return findNode(root.left,p) || findNode(root.right,p);
    }
}
