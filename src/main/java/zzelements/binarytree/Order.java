package zzelements.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
        System.out.println("前序遍历递归" + res);
        return res;
    }

    //单层递归逻辑
    public static void preOrder(TreeNode note, List<Integer> res){
        //中，左，右
        res.add(note.val);
        if (note.left != null){
            preOrder(note.left, res);
        }
        if (note.right != null){
            preOrder(note.right, res);
        }
    }


    //前序遍历迭代法
    public static List<Integer> preOrderTraversalRecursive(TreeNode root){
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null){return res;}

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();
            res.add(curr.val);
            if (curr.right != null)stack.push(curr.right);
            if (curr.left != null)stack.push(curr.left);
        }
        System.out.println("前序遍历迭代" + res);
        return res;
    }
}
