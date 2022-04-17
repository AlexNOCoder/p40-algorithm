package subtree_of_another_tree_572;


import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SolutionByAlex {

//    给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。如果存在，返回 true ；否则，返回 false 。
//
//    二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树。
//
public boolean isSubtree(TreeNode root, TreeNode subRoot) {

    Queue<TreeNode> queue = new LinkedList();
    queue.offer(root);
    while(!queue.isEmpty()){
        TreeNode temp = queue.poll();
        if(isSameTree(temp, subRoot)){
            return true;
        }
        if(temp.left != null){
            queue.offer(temp.left);
        }
        if(temp.right != null){
            queue.offer(temp.right);
        }

    }

    return false;
}

    public boolean isSameTree(TreeNode p, TreeNode q){
        // 递归出口
        if(p == null ||  q == null){
            if(p == q){
                return true;
            }
            return false;
        }
        if(p.val != q.val){
            return false;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
