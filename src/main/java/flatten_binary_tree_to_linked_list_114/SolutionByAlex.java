package flatten_binary_tree_to_linked_list_114;

import common.TreeNode;

public class SolutionByAlex {

    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        // 拉平左右
        flatten(root.left);
        flatten(root.right);
        // 拿到结果
        TreeNode left = root.left;
        TreeNode right = root.right;
        // 处理左右节点
        root.left = null;
        // 找到最右节点
        TreeNode p = root;
        while(p!=null){
            p = p.right;
        }
        p.right = right;
    }

}
