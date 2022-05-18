package binary_tree_zigzag_level_order_traversal_103;


import common.TreeNode;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SolutionByAlex {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = false;
        while(!queue.isEmpty()){
            int size = queue.size();
            LinkedList<Integer> level = new LinkedList<>();

            for(int i=0;i< size;i++){
                TreeNode cur = queue.poll();
                if(flag){
                    level.addFirst(cur.val);
                }else{
                    level.addLast(cur.val);
                }
                if(cur.left != null){
                    queue.offer(cur.left);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                }
            }
            res.add(level);
            flag = !flag;
        }
        return res;
    }
}
