package common.utils;

import com.alibaba.fastjson.JSONObject;
import common.TreeNode;

import java.util.*;

/**
 * @author luoyuntian
 * @program: p40-algorithm
 * @description: 数组生成二叉树
 * @date 2022-04-18 23:13:04
 */
public class GenerateBinaryTree {
    public static TreeNode sortedArrayToBST(int[] nums) {
        Arrays.sort(nums);
        return dfs(nums,0,nums.length-1);
    }
    public static TreeNode dfs(int[]nums,int l,int r){
        if(l>r) return null;
        int mid= l+(r-l)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=dfs(nums,l,mid-1);
        root.right=dfs(nums,mid+1,r);
        return root;
    }

    public static void main(String[] args) {
        int[] array = {1,3,7,6,2,5,4} ;
        Arrays.sort(array);
        System.out.println(JSONObject.toJSONString(array,true));
        System.out.println(JSONObject.toJSONString(sortedArrayToBST(array),true));
        List<Integer> list = new ArrayList();
        list.stream().count();
    }

}
