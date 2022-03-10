package common.other;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author luoyuntian
 * @program: p40-algorithm
 * @description: 二叉树
 * @date 2022-03-02 07:51:02
 */
public class BinaryTree {
    // 树节点
    private class TreeNode{
        // 数据
        int data;
        // 左孩子
        TreeNode leftChild;
        // 右孩子
        TreeNode rightChild;

        public TreeNode(int data){
            this.data = data;
        }
    }

    TreeNode root;
    public void insertNode(int data){
        root = insert(root,data);
    }

    private TreeNode insert(TreeNode node,int data){
        // 如果是空则插入第一个节点
        if(node == null){
            return new TreeNode(data);
        }
        // 插入左边
        if(data < node.data){
            node.leftChild = insert(node.leftChild,data);
        }
        // 插入右边
        else if(data > node.data){
            node.rightChild = insert(node.rightChild,data);
        }else {
            node.data = data;
        }
        return node;
    }
    //前序
    public void preOrderTraversal(TreeNode node){
        if(node == null){
            return;
        }
        System.out.println(node.data);
        preOrderTraversal(node.leftChild);
        preOrderTraversal(node.rightChild);
    }
    // 中序
    public void inOrderTraversal(TreeNode node){
        if(node == null){
            return;
        }
        inOrderTraversal(node.leftChild);
        System.out.println(node.data);
        inOrderTraversal(node.rightChild);
    }
    // 后序
    public void postOrderTraversal(TreeNode node){
        if(node == null){
            return;
        }
        postOrderTraversal(node.leftChild);
        postOrderTraversal(node.rightChild);
        System.out.println(node.data);
    }

    public void levelOrderTraversal(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
           TreeNode node = queue.poll();
            System.out.println(node.data);
            if(node.leftChild != null){
                queue.offer(node.leftChild);
            }
            if(node.rightChild != null){
                queue.offer(node.rightChild);
            }
        }
    }

}
