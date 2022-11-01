package zzelements.binarytree;

/**
 * @program: p40-algorithm
 * @description: 创建二叉树测试
 * @author: lijie
 * @create: 2022-11-01 21:39
 */
public class CreateBinaryTreeTest {

    public static void main(String[] args){
        //递归建树数据
        Integer[] data = {1,2,3,null,null,null,3,null,null};
        //层序建立二叉树数据

    }

    public static void TestOneBinaryTree(Integer[] data){
        BinaryTree<Integer> binaryTree = new BinaryTree<>(data);
        //前序遍历
        Order.preOrderTraversal(binaryTree.getRoot());

        // TODO: 2022/11/1
    }
}
