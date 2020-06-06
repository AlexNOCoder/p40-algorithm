package maximum_depth_of_nary_tree_559;
import common.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SolutionByAlex {
    public int maxDepth(Node root) {
        if(root == null){
            return 0;
        }
        Queue<Node> queue = new LinkedList();
        queue.offer(root);
        int depth = 1;
        List<Node> nodes = new ArrayList();
        while(!queue.isEmpty()){

            Node temp = queue.poll();
            for(Node node:temp.neighbors){
                nodes.add(node);
            }
            if(queue.isEmpty() && nodes.size()>0){
                depth++;
                for(Node node:nodes){
                    queue.offer(node);
                }
                nodes.clear();
            }
        }
        return depth;
    }


}

