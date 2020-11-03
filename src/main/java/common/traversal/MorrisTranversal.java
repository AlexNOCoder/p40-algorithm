package common.traversal;

import common.TreeNode;

/**
   * @description morris遍历二叉树，可以将非递归遍历中的空间复杂度降为O(1)。从而实现时间复杂度为O(N),而空间复杂度为O(1)的精妙算法
 * morris遍历利用的是树的叶子节点左右孩子为空（树的大量空闲指针），实现空间开销的极限缩减
   */
public class MorrisTranversal {

    //前序遍历
    public static void morrisPre(TreeNode head){
        if(head == null){
            return;
        }
        TreeNode cur = head;
        TreeNode mostRight = null;
        while (cur != null){
            mostRight = cur.left;
            if(mostRight != null){
                while (mostRight.right !=null && mostRight.right != cur){
                    mostRight = mostRight.right;
                }
                if(mostRight.right == null){
                    mostRight.right = cur;
                    System.out.print(cur.val+" ");
                    cur = cur.left;
                    continue;
                }else {
                    mostRight.right = null;
                }
            }else {
                System.out.print(cur.val + " ");
            }
            cur = cur.right;
        }
        System.out.println();
    }

    //中序遍历
    public static void morrisIn(TreeNode head){
        if(head == null){
            return;
        }
        TreeNode cur = head;
        TreeNode mostRight = null;
        while (cur != null){
            mostRight = cur.left;
            if(mostRight != null){
                while (mostRight.right !=null && mostRight.right != cur){
                    mostRight = mostRight.right;
                }
                if(mostRight.right == null){
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }else {
                    mostRight.right = null;
                }
            }
            System.out.print(cur.val+" ");
            cur = cur.right;
        }
        System.out.println();
    }


    //后序遍历
    public static void morrisPos(TreeNode head){
        if(head == null){
            return;
        }
        TreeNode cur = head;
        TreeNode mostRight = null;
        while (cur != null){
            mostRight = cur.left;
            if(mostRight != null){
                while (mostRight.right !=null && mostRight.right != cur){
                    mostRight = mostRight.right;
                }
                if(mostRight.right == null){
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }else {
                    mostRight.right = null;
                    printEdge(cur.left);
                }
            }
            cur = cur.right;
        }
        printEdge(head);
        System.out.println();
    }

    public static void printEdge(TreeNode node){
        TreeNode tail =reverseEdge(node);
        TreeNode cur = tail;
        while (cur != null ){
            System.out.print(cur.val+" ");
            cur =cur.right;
        }
        reverseEdge(tail);
    }

    public static TreeNode reverseEdge(TreeNode node){
        TreeNode pre = null;
        TreeNode next = null;
        while (node != null){
            next = node.right;
            node.right = pre;
            pre = node;
            node = next;
        }
        return pre;
    }
}
