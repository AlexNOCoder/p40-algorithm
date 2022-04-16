package binary_tree_postorder_traversal_145;


import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SolutionByAlex {
    List<Integer> list = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        postorder(root);
        return list;
    }
    public void postorder(TreeNode root){
        if(root == null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        list.add(root.val);
    }


}
