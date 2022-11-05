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

    //二叉树最小深度
    public static int minDepth(TreeNode root){
        int i = getMinHigh(root);
        System.out.println("二叉树最小深度："+i);
        return i;
    }
    //使用后续遍历 左右中的顺序
    public static int getMinHigh(TreeNode node){
        if (node == null){return 0;}
        int leftHigh = getMinHigh(node.left);
        int rightHigh = getMinHigh(node.right);
        if (node.left == null && node.right != null){return 1 + rightHigh;}
        if (node.right == null && node.left != null){return 1 + leftHigh;}
        int result = 1 + (leftHigh < rightHigh ? leftHigh : rightHigh);
        return result;
    }

    //完全二叉树的节点数（普通递归）
    public static int countNode(TreeNode root){
        int result = getNum(root);
        System.out.println("完全二叉树的节点数：" + result);
        return result;
    }

    //完全二叉树的性质：1.除了最后一排，都是满的。2.最后一排从左往右排列。
    //获取层数：一直向左遍历
    //递归法处理，使用了后续遍历，如果使用精简的写法则不能看出里面的逻辑。
    public static int getNum(TreeNode node){
        if (node == null){return 0;}
        int leftNum = getNum(node.left);  //左
        int rightNum = getNum(node.right);  //右
        int result = leftNum + rightNum + 1; //中

        return result;
    }

    //完全二叉树节点数（满二叉树性质递归）
    public static int countNodeAttribute(TreeNode root){
        int result =getNumAttribute(root);
        System.out.println("完全二叉树的节点数量（满二叉树的性质  ）：" + result);
        return result;
    }

    public static int getNumAttribute(TreeNode node){
        if (node == null){return 0;}
        TreeNode left = node.left;
        TreeNode right = node.right;
        int leftDepth = 0;
        int rightDepth = 0;
        while (left != null){
            left = left.left;
            leftDepth ++;
        }
        while (right != null){
            right = right.right;
            rightDepth ++;
        }
        if (leftDepth == rightDepth){return (2<<leftDepth) - 1; }
        leftDepth = getNumAttribute(node.left);
        rightDepth = getNumAttribute(node.right);
        int result = leftDepth + rightDepth +1;
        return result;
    }

    //平衡二叉树
    public static boolean isBalanced(TreeNode root){
        int result = gethigh(root);
        System.out.println("数字结果" + result);
        if (result == -1){return false;}else {return true;}
    }

    //求高度用后续遍历-左右中-从底层向上递归
    public static int gethigh(TreeNode node){
        if (node == null){return 0;}
        int leftHeigh = getHigh(node.left);//左
        if (leftHeigh == -1){return -1;}
        int rightHeigh = getHigh(node.right);//右
        if (rightHeigh == -1){return -1;}
        int result;
        if (Math.abs(rightHeigh - leftHeigh) > 1){result = -1;}//中
        else {result = 1 + rightHeigh > leftHeigh ? rightHeigh : leftHeigh;}
        return result;
    }
}
