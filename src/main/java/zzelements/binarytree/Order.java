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
        //设置数据结构数组用来返回结果
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null){return res;}

        //把根节点放入栈中
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        //从根节点开始判断，开始循环；先把栈最上面的元素弹出并放入结果数组中，第一次放入根节点，即开始前序遍历；
        //第二步将根节点的左右节点放入栈中，如果不为空就放，先放右节点，再放左节点，这样弹出时就先左后右了；
        //循环判断栈不为空，继续执行；左节点弹出之后，判断当前节点即已经弹出的左节点的子节点是否为空，并按照且继续按照先右后左的顺序压入栈；
        //这样的效果就是，先处理根节点，再处理根节点的左子树，这时右子树保留了一个根节点在栈中；处理完左子树的所有节点后，根据栈中保留的右子树的
        //根节点继续处理。也是一种递归的感觉。
        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();
            res.add(curr.val);
            if (curr.right != null)stack.push(curr.right);
            if (curr.left != null)stack.push(curr.left);
        }
        System.out.println("前序遍历迭代" + res);
        return res;
    }

    //中序遍历二叉树 迭代法
    public static List<Integer> inorderTraversalRecursive(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root == null)return res;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while(curr != null || !stack.isEmpty()){
            //使用指针访问节点，到左边最底层
            //也就是要找到第一个要访问的节点
            //把左边路径的元素按照先父后子的顺序放入栈中
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }

            //从栈里弹出数据并放入返回数组中
            TreeNode node = stack.pop();
            res.add(node.val);
            //最左的叶子节点弹出后，设置curr为空。
            //当前节点为空但是栈不为空就继续弹，在把当前节点设置为弹出的节点的右节点。
            curr = node.right;
        }
        System.out.println("中序遍历迭代" + res);
        return res;
    }
}
