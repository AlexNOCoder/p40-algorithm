package clone_graph_133;

import common.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class SolutionByAlex {
    Map<Node,Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
       if(node == null){
           return null;
       }
       if(map.containsKey(node)){
           return map.get(node);
       }

       Node myClone = new Node(node.val,new ArrayList<>());

       map.put(node,myClone);

       for(Node neighbor:node.neighbors){
           myClone.neighbors.add(cloneGraph(neighbor));
       }
       return myClone;

    }



}
