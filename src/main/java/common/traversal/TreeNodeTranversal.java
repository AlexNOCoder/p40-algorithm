package common.traversal;

import common.TreeNode;

/**
   * @author luoyuntian
   * @date 2020-09-19 14:17
   * @description 本类是汇总了二叉树的前序、中序、后序遍历的递归方法和非递归方法
   */
public class TreeNodeTranversal {
    /**
        递归版本：
        1.确定递归函数的参数和返回值：入参为TreeNode，打印节点无返回值
        2.确定终止条件：当遍历到入参为null的TreeNode时，就不用再继续递归往程序栈加入栈帧，取出程序栈栈顶元素来处理
        3.确定单层递归的逻辑：确定前中后序的遍历逻辑，对根节点、左子节点、右子节点进行按序遍历
       */

    public static void preOrderTraversalByRecursion(TreeNode root){
        if(root == null){
            return;
        }
        System.out.println(root.val);
        preOrderTraversalByRecursion(root.left);
        preOrderTraversalByRecursion(root.right);
    }

    public static void postOrderTraversalByRecursion(TreeNode root){
        if(root == null){
            return;
        }
        postOrderTraversalByRecursion(root.left);
        postOrderTraversalByRecursion(root.right);
        System.out.println(root.val);
    }


    public static void inOrderTraversalByRecursion(TreeNode root){
        if(root == null){
            return;
        }
        inOrderTraversalByRecursion(root.left);
        System.out.println(root.val);
        inOrderTraversalByRecursion(root.right);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(8);
        System.out.println("============前序遍历递归==============");
        preOrderTraversalByRecursion(root);
        System.out.println("============中序遍历递归==============");
        inOrderTraversalByRecursion(root);
        System.out.println("============后序遍历递归==============");
        postOrderTraversalByRecursion(root);
    }
}
