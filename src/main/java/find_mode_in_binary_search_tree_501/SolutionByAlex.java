package find_mode_in_binary_search_tree_501;

import common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *时间复杂度，空间复杂度爆炸，
 */
public class SolutionByAlex {

    public static int[] findMode(TreeNode root) {
        List<Integer> orderResult = inOrder(root);
        HashMap<Integer,Integer> numMap = new HashMap<>();
        int maxNum = 0;
        for(Integer i:orderResult){
            if(!numMap.containsKey(i)){
                numMap.put(i,1);
                if(maxNum<1){
                    maxNum = 1;
                }
            }else {
                Integer num = numMap.get(i);
                num++;
                numMap.put(i,num);
                if(maxNum < num){
                    maxNum = num;
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for(Map.Entry en:numMap.entrySet()){
            if(en.getValue().equals(maxNum)){
               result.add((Integer) en.getKey());
            }
        }
        int[] count = new int[result.size()];
        for(int i=0;i<result.size();i++){
            count[i] = result.get(i);
        }
        return count;
    }
    private  static List<Integer> result = new ArrayList<>();
    public static List<Integer> inOrder(TreeNode root){
        if(root != null){
            inOrder(root.left);
            System.out.println(root.val);
            result.add(root.val);
            inOrder(root.right);
        }
        return result;
    }

}
