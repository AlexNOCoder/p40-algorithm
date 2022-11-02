package zzelements.binarytree;

/**
 * @program: p40-algorithm
 * @description: 二叉树节点
 * @author: lijie
 * @create: 2022-10-31 22:32
 */
public class TreeNode {
    //数据
    Integer val;
    //左节点
    public TreeNode left;
    //右节点
    public TreeNode right;

    //有参构造器
    public TreeNode(Integer x){
        val = x;
    }

    //无参构造器
    public TreeNode(){}

    @Override
    public String toString(){
        return "TreeNode{" + "val = " + val + ",left" + left + ",right" + right + "}";
    }
}
