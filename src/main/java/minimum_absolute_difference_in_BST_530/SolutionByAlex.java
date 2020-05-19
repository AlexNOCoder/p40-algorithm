package minimum_absolute_difference_in_BST_530;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
//时间复杂度和空间复杂度爆炸
public class SolutionByAlex {

    public static int getMinimumDifference(TreeNode root) {
        int result = Integer.MAX_VALUE;
        List<Integer> allNode = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty()){
            TreeNode peek = stack.pop();
            allNode.add(peek.val);
            if(peek.left != null){
                stack.push(peek.left);
            }
            if(peek.right != null){
                stack.push(peek.right);
            }
        }
        for(int i =0;i < allNode.size();i++){
            for(int j=0;j < allNode.size();j++){
                if(i != j){
                    int diff = Math.abs(allNode.get(i) - allNode.get(j));
                    if(diff < result){
                        result = diff;
                    }
                }
            }
        }
        return result;
    }

}
