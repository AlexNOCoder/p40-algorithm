package zzelements.binarytree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: p40-algorithm
 * @description: 二叉树的属性
 * @author: lijie
 * @create: 2022-11-03 23:25
 */
public class Attribute {

    //判断二叉树是否对称 递归
    public static boolean isSymmetric(TreeNode root){
        boolean b = check(root, root);
        System.out.println("判断对称二叉树 递归" + b);
        return b;
    }

    //实现一个递归函数，通过【同步移动】两个指针的方法来遍历这颗树。p指针和q指针开始都指向这棵树的根
    //随后p右移，q左移，值相等再判断左右子树是否相等。
    public static boolean check(TreeNode p, TreeNode q){
        if (p == null && q == null){return true;}
        if (p == null || q == null){return false;}
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }

    //对称二叉树 迭代
    //引入一个队列，这是把递归程序改写为迭代程序的常用方法。
    //使用普通队列
    public static boolean isSymmetrixRecursive(TreeNode root){
        Queue<TreeNode> deque = new LinkedList<>();
        deque.offer(root.left);
        deque.offer(root.right);
        while (!deque.isEmpty()){
            TreeNode leftNode = deque.poll();
            TreeNode rightNode = deque.poll();
            if (leftNode == null && rightNode == null){continue;}
            if (leftNode == null || rightNode == null || leftNode.val != rightNode.val){
                System.out.println("判断对称二叉树 迭代 普通队列"+false);
                return false;
            }
            deque.offer(leftNode.left);
            deque.offer(rightNode.right);
            deque.offer(leftNode.right);
            deque.offer(rightNode.left);
        }
        System.out.println("判断对称二叉树 迭代 普通队列"+true);
        return true;
    }

    //对称二叉树 迭代
    //使用双端队列，相当于两个栈。
    public static boolean isSymmetrixRecursive2(TreeNode root){
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerFirst(root.left);
        deque.offerLast(root.right);
        while(!deque.isEmpty()){
            TreeNode leftNode = deque.pollFirst();
            TreeNode rightNode = deque.pollLast();
            if (leftNode == null && rightNode == null){continue;}
            if (leftNode == null || rightNode == null || leftNode.val != rightNode.val){System.out.println("判断对称二叉树 迭代 双端队列"+false);;return false;}
            deque.offerFirst(leftNode.left);
            deque.offerFirst(leftNode.right);
            deque.offerLast(rightNode.right);
            deque.offerLast(rightNode.left);
        }
        System.out.println("判断对称二叉树 迭代 双端队列"+true);
        return true;
    }

    //二叉树最大深度
    public static int maxDepth(TreeNode root){
        int i = getHigh(root);
        System.out.println("二叉树的最大深度："+ i);
        return i;
    }
    //使用了后续遍历 左右中的顺序
    public static int getHigh(TreeNode node){
        if (node == null){return 0;}
        int leftHigh = getHigh(node.left); //左
        int rightHigh = getHigh(node.right);  //右
        int high = leftHigh > rightHigh ? leftHigh : rightHigh;  //中
        return high + 1;
    }
}
