package merge_two_binary_trees_617;

import common.TreeNode;

public class SolutionByAlex {
//    想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。
//    你需要将这两棵树合并成一棵新二叉树。
//    合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；
//    否则，不为 null 的节点将直接作为新二叉树的节点。
//    返回合并后的二叉树。
//    注意: 合并过程必须从两个树的根节点开始。

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // 取非空节点，或者合并值创造新节点
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode merged = new TreeNode(root1.val + root2.val);
        merged.left = mergeTrees(root1.left, root2.left);
        merged.right = mergeTrees(root1.right, root2.right);
        return merged;
    }

}

