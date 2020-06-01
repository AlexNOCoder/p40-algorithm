package linked_list_in_binary_tree;

import common.ListNode;
import common.TreeNode;

/**
 * copy from 二叉树中的列表
 * @author : wangcheng
 * @date : 2020年06月01日 16:15
 */
public class SolutionByCdtft {

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) {
            return false;
        }
        return match(head, root) || isSubPath(head, root.right) || isSubPath(head, root.left);
    }

    private boolean match(ListNode node, TreeNode root) {
        if (node == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (node.val != root.val) {
            return false;
        }
        return match(node.next, root.left) || match(node.next, root.right);
    }

}
