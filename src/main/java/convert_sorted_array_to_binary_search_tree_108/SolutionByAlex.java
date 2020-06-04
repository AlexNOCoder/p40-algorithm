package convert_sorted_array_to_binary_search_tree_108;


import common.TreeNode;

public class SolutionByAlex {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length ==0){
            return null;
        }
        if(nums.length == 1){
            return new TreeNode(nums[0]);
        }
        int middle = nums.length/2;
        int[] left = new int[middle];
        int[] right = new int[nums.length-1-middle];
        for(int i=0;i<left.length;i++){
            left[i] = nums[i];
        }
        for(int j=0;j<right.length;j++){
            right[j] = nums[j+middle+1];
        }
        TreeNode root = new TreeNode(nums[middle]);
        root.left = sortedArrayToBST(left);
        root.right = sortedArrayToBST(right);
        return root;

    }
}
