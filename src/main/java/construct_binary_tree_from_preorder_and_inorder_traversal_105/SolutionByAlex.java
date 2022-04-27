package construct_binary_tree_from_preorder_and_inorder_traversal_105;

import common.TreeNode;

public class SolutionByAlex {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return bulid(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    public TreeNode bulid(int[] preorder,int preStart,int preEnd, int[] inorder,int inStart,int inEnd){
        if(preStart > preStart){
            return null;
        }
        int rootVal = preorder[preStart];
        int index =0;
        for(int i=inStart;i<= inEnd;i++){
            if(inorder[i] == rootVal){
                index = i;
                break;
            }
        }
        int leftSize = index - inStart;
        TreeNode root = new TreeNode(rootVal);
        root.left = bulid(preorder,preStart+1,preStart+leftSize,inorder,inStart,index-1);
        root.right = bulid(preorder,preStart+leftSize+1,preEnd,inorder,index+1,inEnd);
        return root;

    }

}
