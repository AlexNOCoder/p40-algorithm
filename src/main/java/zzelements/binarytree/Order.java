package zzelements.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: p40-algorithm
 * @description: 二叉树排序
 * @author: lijie
 * @create: 2022-10-31 22:30
 */
public class Order {

    //前序遍历 + 递归
    public static List<Integer> preOrderTraversal(TreeNode root){
        //设置一个数据（数组）结构用来返回结果
        ArrayList<Integer> res = new ArrayList();
        //如果根节点为空，返回空数组。
        if (root == null){return res;}
        //调用递归函数
        preOrder(root, res);
        //返回结果
        System.out.println(res);
        return res;
    }

    //单层递归逻辑
    public static void preOrder(TreeNode note, List<Integer> res){
        //中，左，右
        res.add(note.val);
        preOrder(note.left, res);
        preOrder(note.right, res);
    }
}
