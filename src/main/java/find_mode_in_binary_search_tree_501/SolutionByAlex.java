package find_mode_in_binary_search_tree_501;

import common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SolutionByAlex {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left =  new TreeNode(4);
        root.right = new TreeNode(4);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(4);
//        inOrder(root);
//        findMode(root);
        System.out.println(findEqualNum(root));
    }

    public static int[] findMode(TreeNode root) {
        int[] orderResult = inOrder(root);
        int[]  result = new int[4];
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
        int i =0;
        for(Map.Entry en:numMap.entrySet()){
            if(en.getValue().equals(maxNum)){
               Integer value = (Integer) en.getKey();
               result[i] = value.intValue();
               i++;
            }
        }

        return result;
    }
//    private static  int count =0;
    private  static int[] result =new int[5];
    public static int[] inOrder(TreeNode root){

        if(root != null){
            inOrder(root.left);
            System.out.println(root.val);
            result[count] = root.val;
            count++;
            inOrder(root.right);
        }
        return result;
    }

    public static void preOrder(TreeNode root){
        if(root != null){
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    private static int count = 1;
    public static  int  findEqualNum(TreeNode root){

        int val = root.val;
        if(root.left != null){
            int val_left = root.left.val;
            if(val == val_left){
                count++;
                findEqualNum(root.left);
            }
        }
        if(root.right != null){
            int val_right = root.right.val;
            if(val == val_right){
                count++;
                findEqualNum(root.left);
            }
        }

        return count;

    }
}
