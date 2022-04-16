package binary_tree_paths_257;

import common.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class SolutionByAlex {


    // 全局变量，记录递归函数的递归层数
    public static int count = 0;

    // 输入n,打印n个tab缩进
    public static void printIndent(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("  ");
        }
    }
    static List<String> list = new LinkedList<>();
    // 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
    public static List<String> binaryTreePaths(TreeNode root) {
        findPath(root,"");
        return list;
    }

    public static void  findPath(TreeNode root,String path){
//        printIndent(count++);
//        System.out.println(String.format("path = %s",path));
        if(root == null){
            return;
        }
        if( root.right == null && root.left == null){
//            printIndent(--count);
            path = change(path, root.val);
//            System.out.println("add "+path);
            list.add(path);
            return;
        }
        path = change(path, root.val);
        findPath(root.left,path);
        findPath(root.right,path);
//        printIndent(--count);
    }

    public static String change(String path,Integer val){
        if(!path.equals("")){
            return path +"->"+val;
        }else{
            return val+"";
        }
    }


    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.right = new TreeNode(5);
        binaryTreePaths(head);
        System.out.println(list);
    }
}
