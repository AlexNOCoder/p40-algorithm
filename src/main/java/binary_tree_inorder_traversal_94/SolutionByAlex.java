package binary_tree_inorder_traversal_94;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
//递归解法另外还有迭代与螺纹二叉树解法
public class SolutionByAlex {
    List<Integer> result =  new ArrayList();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null){
            return result;
        }
        inorder(root);
        return result ;
    }

    public void inorder(TreeNode root){
        if(root == null){
            return;
        }

        if(root.left != null){
            inorder(root.left);
        }

        result.add(root.val);

        if(root.right != null){
            inorder(root.right);
        }


    }

}
