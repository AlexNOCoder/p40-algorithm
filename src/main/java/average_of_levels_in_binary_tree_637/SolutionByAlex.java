package average_of_levels_in_binary_tree_637;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class SolutionByAlex {
    // 给定一个非空二叉树的根节点 root ,
    // 以数组的形式返回每一层节点的平均值。
    // 与实际答案相差 10-5 以内的答案可以被接受。
    public static List<Double> averageOfLevels(TreeNode root) {
        // 层次遍历，记录每层的和与节点个数，然后将结果返回
        List<Double> result = new ArrayList<>();
        List<TreeNode> levelList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        levelList.add(root);
        while(!queue.isEmpty()){
            int size = levelList.size();
            result.add(averageOfList(levelList));
            levelList.clear();
            for(int i=0;i<size;i++){
                TreeNode temp = queue.poll();
                if(temp.left != null){
                    queue.offer(temp.left);
                    levelList.add(temp.left);
                }
                if(temp.right != null){
                    queue.offer(temp.right);
                    levelList.add(temp.right);
                }
            }
        }
        return result;
    }
    public static  Double averageOfList(List<TreeNode> list){
        return list.stream().map(a -> a.val).collect(Collectors.averagingDouble(n -> n));
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(3);
        head = new TreeNode(3);
        head.left = new TreeNode(9);

        head.right = new TreeNode(20);
        head.right.left = new TreeNode(15);
        head.right.right = new TreeNode(7);
        System.out.println(averageOfLevels(head));;
    }
}
