package deepest_leaves_sum_1302;

import common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SolutionByAlex {
    public int deepestLeavesSum(TreeNode root) {
        int resultCount = 0;
        List<Integer> result;
        List<Integer> list = new LinkedList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        list.add(root.val);
        while(!queue.isEmpty()){
            int size = list.size();
            int count=0;
            for(int i:list){
                count+=i;
            }
            resultCount=count;
            list.clear();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                    list.add(node.left.val);
                }
                if(node.right != null){
                    queue.offer(node.right);
                    list.add(node.right.val);
                }
            }
        }

        return resultCount;
    }

}


