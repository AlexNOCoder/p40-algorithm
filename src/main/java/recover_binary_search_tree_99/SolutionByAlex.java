package recover_binary_search_tree_99;

import common.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class SolutionByAlex {
    TreeNode first,second;
    TreeNode pre = new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        inOrder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    public void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        if(root.val < pre.val){
            if(first == null){
                first = pre;
            }
            second = root;
        }
        pre = root;
        inOrder(root.right);
    }

}
