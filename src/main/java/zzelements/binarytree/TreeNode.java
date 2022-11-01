package zzelements.binarytree;

/**
 * @program: p40-algorithm
 * @description: 二叉树节点
 * @author: lijie
 * @create: 2022-10-31 22:32
 */
public class TreeNode<E> {
    E val;
    public TreeNode left = null;
    public TreeNode right = null;

    public TreeNode(E x){
        val = x;
    }

    public TreeNode(){}

    @Override
    public String toString(){
        return "TreeNode{" + "val = " + val + ",left" + left + ",right" + right + "}";
    }
}
