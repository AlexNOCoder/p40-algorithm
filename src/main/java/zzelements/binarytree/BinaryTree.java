package zzelements.binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: p40-algorithm
 * @description: 基本二叉树结构，当使用数组传入数据时，默认递归建树，也可以建立空树，选择递归或者层序建立二叉树
 * @author: lijie
 * @create: 2022-10-31 23:31
 */
public class BinaryTree<E> {
    //根节点
    private TreeNode<E> root = null;

    //建立二叉树时，用于缓存数据的栈空间
    private LinkedList<E> stack = null;

    //保存二叉树数据的列表
    private List<E> elements = new ArrayList<>();

    //无参构造器
    public BinaryTree(){}

    /**
     * 有参构造方法，默认左递归建立二叉树
     * 需要传入左递归顺序的数据
     * @param data 左递归顺序的数组数据
     */
    public BinaryTree(E[] data){
        this.stack = new LinkedList<E>(Arrays.asList(data));
        CreateBinaryTree();
    }

    public TreeNode<E> getRoot(){
        return this.root;
    }
    public void setRoot(TreeNode<E> root){
        this.root = root;
    }

    /**
     * 左递归建立二叉树
     */
    private void CreateBinaryTree(){
        if (!stack.isEmpty()){
            this.root = recursiveCreateBinaryTree(root, stack);
        }else{
            this.root = null;
        }
    }

    /**
     * 左递归建立二叉树，需要传入左递归顺序的二叉树数据
     * @param data
     */
    public void recursiveCreateBinatyTree(E[] data){
        this.stack = new LinkedList<E>(Arrays.asList(data));
        if (!stack.isEmpty()){
            this.root = recursiveCreateBinaryTree(this.root, this.stack);
        }else{
            this.root = null;
        }
    }

    /**
     * 左递归建立二叉树，核心算法
     * @param node
     * @param stack
     * @return返回跟节点
     */
    private TreeNode<E> recursiveCreateBinaryTree(TreeNode<E> node, LinkedList<E> stack){
        if(!stack.isEmpty()){
            E value = stack.pop();
            if (value == null){
                node = null;
            }else {
                node = new TreeNode<>();
                node.val = value;
                node.left = recursiveCreateBinaryTree(node.left, stack);
                node.right = recursiveCreateBinaryTree(node.right, stack);
            }
        }else {
            return null;
        }
        return node;
    }



}
