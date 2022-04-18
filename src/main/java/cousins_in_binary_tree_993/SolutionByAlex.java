package cousins_in_binary_tree_993;

import common.TreeNode;

import java.util.*;

public class SolutionByAlex {
//    在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
//    如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。
//    我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。
//    只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。

    public static boolean isCousins(TreeNode root, int x, int y) {
        boolean samleLevel = isSameLevel(root, x, y);
        boolean brother = isBrother(root, x, y);
        return samleLevel && !brother;
    }

    // 判断是否是同层级
    public static boolean isSameLevel(TreeNode root, int x, int y) {
        Set<Integer> sameLevelNums = new HashSet<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        sameLevelNums.add(root.val);
        while (!queue.isEmpty()) {
            int size = sameLevelNums.size();
            sameLevelNums.clear();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if(temp.left !=null){
                    queue.offer(temp.left);
                    sameLevelNums.add(temp.left.val);
                }
                if(temp.right !=null){
                    queue.offer(temp.right);
                    sameLevelNums.add(temp.right.val);
                }
            }
            if(sameLevelNums.contains(x) && sameLevelNums.contains(y)){
                return true;
            }
        }
        return false;
    }

    public static boolean isBrother(TreeNode root, int x, int y){
        if(root != null){
            if(root.left != null && root.right != null){
                if((root.left.val == x && root.right.val == y) || (root.left.val == y && root.right.val == x)){
                    return true;
                }
            }
            return isBrother(root.left, x, y) || isBrother(root.right, x, y);
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.right.left = new TreeNode(4);
        head.right.right = new TreeNode(5);
        isCousins(head,5,4);
    }

}


