package binary_tree_preorder_traversal_144;


import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SolutionByAlex {
    // 遍历方式
//    List<Integer> list = new ArrayList<>();
//    public List<Integer> preorderTraversal(TreeNode root) {
//        preorder(root);
//        return list;
//    }
//    public void preorder(TreeNode root){
//        if(root == null){
//            return;
//        }
//        list.add(root.val);
//        preorder(root.left);
//        preorder(root.right);
//    }

    // 分解子问题
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null){
            return new LinkedList<Integer>();
        }
        List<Integer> left = preorderTraversal(root.left);
        List<Integer> right = preorderTraversal(root.right);
        List<Integer>  all = new LinkedList<Integer>();
        all.add(root.val);
        if(left != null){
            all.addAll(left);
        }
        if(right != null){
            all.addAll(right);
        }

        return all;
    }
}
