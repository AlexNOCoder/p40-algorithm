package construct_binary_tree_from_inorder_and_postorder_traversal_106;

import common.TreeNode;

public class SolutionByAlex {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }

    public TreeNode build(int[] inorder,int istart,int iend, int[] postorder,int pstart,int pend){
        if(pstart > pend){
            return null;
        }
        int rootVal = postorder[pend];
        int index  = 0 ;
        for(int i=istart;i <= iend;i++){
            if(inorder[i] == rootVal){
              index = i;
              break;
            }
        }
        int leftSize = index - istart;
        TreeNode root = new TreeNode(rootVal);
        root.left = build(inorder,istart,index-1,postorder,pstart,pstart+leftSize-1);
        root.right = build(inorder,index+1,iend,postorder,pstart+leftSize,pend-1);
        return root;
    }

}