package construct_string_from_binary_tree_606;

import common.TreeNode;

public class SolutionByAlex {

//    你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
//
//    空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。

    // 通过前序遍历生成字符串
    // 替换字符串()) 为）
    String result = "";

    public String tree2str(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val + "";
        }
        preorder2Str(root);
        return result.replaceAll("\\(\\)\\)", "\\)");
    }

    public void preorder2Str(TreeNode root) {
        // 结束条件
        if (root == null) {
            return;
        }
        String nodeVal = root.val + "";

        result = result + nodeVal;
        result = result + "(";
        preorder2Str(root.left);
        result = result + ")";

        if (root.right != null) {
            result = result + "(";
            preorder2Str(root.right);
            result = result + ")";
        }
    }


}
