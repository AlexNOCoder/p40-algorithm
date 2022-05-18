package create_binary_tree_from_descriptions_2196;

import common.TreeNode;

import java.util.*;

public class SolutionByAlex {
    Map<Integer,TreeNode> map = new HashMap<>();
    Set<Integer> childs = new HashSet<>();
    public TreeNode createBinaryTree(int[][] descriptions) {
        TreeNode res= null;
        for(int[] description:descriptions){
            int rootVal = description[0];
            int childVal = description[1];
            int childType = description[2];
            childs.add(childVal);
            TreeNode root = map.getOrDefault(rootVal,new TreeNode(rootVal));
            TreeNode child = map.getOrDefault(childVal,new TreeNode(childVal));
            if(childType == 1){
                root.left = child;
            }else{
                root.right = child;
            }
            map.put(rootVal,root);
            map.put(childVal,child);
        }
        for(Integer i:map.keySet()){
            if(!childs.contains(i)){
                res = map.get(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        String s = "";
        s.substring(1,2);
    }

}


