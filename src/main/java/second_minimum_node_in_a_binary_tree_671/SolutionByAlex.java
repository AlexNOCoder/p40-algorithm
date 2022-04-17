package second_minimum_node_in_a_binary_tree_671;

import common.TreeNode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class SolutionByAlex {
//    给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为2或0。
//    如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
//    更正式地说，即root.val = min(root.left.val, root.right.val) 总成立。
//    给出这样的一个二叉树，你需要输出所有节点中的第二小的值 。
//    如果第二小的值不存在的话，输出 -1 。

    Set<Integer> set = new HashSet<>();

    public int findSecondMinimumValue(TreeNode root) {
        preOrder(root);
        if (set.size() < 2) {
            return -1;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for (Integer i : set) {
            queue.offer(i);
        }
        queue.poll();
        return queue.poll();
    }

    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        set.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    // 全局变量，记录递归函数的递归层数
    public static int count = 0;

    // 输入n,打印n个tab缩进
    public static void printIndent(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("  ");
        }
    }

    static int min;
    static Integer seconde_min;

    public static int findSecondMinimumValue1(TreeNode root) {
        min = root.val;
        seconde_min = null;
        preOrderFind(root);
        return (seconde_min == null) ? -1 : seconde_min;
    }

    public static void preOrderFind(TreeNode root) {
        if (root == null) {
            return;
        }
        if (seconde_min == null) {
            if (root.val > min) {
                seconde_min = root.val;
            }
        } else {
            if (root.val > min && root.val < seconde_min) {
                seconde_min = root.val;
            }
        }
        preOrderFind(root.left);
        preOrderFind(root.right);

    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(2);
        head.left = new TreeNode(2);
        head.right = new TreeNode(5);
        head.right.left = new TreeNode(5);
        head.right.right = new TreeNode(7);
        findSecondMinimumValue1(head);
    }
}
