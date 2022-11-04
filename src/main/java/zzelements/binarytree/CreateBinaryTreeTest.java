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
        Integer[] data1 = {1,2,3,3,4,4,3};
        //建立递归二叉树
        TestOneBinaryTree(data1);

    }

    public static void TestOneBinaryTree(Integer[] data1){
//        BinaryTree binaryTree = new BinaryTree(data1);
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.SequenceCreateBinaryTree(data1);
        //前序遍历 递归
        Order.preOrderTraversal(binaryTree.getRoot());

        //前序遍历 迭代
        Order.preOrderTraversalRecursive(binaryTree.getRoot());

        //中序遍历 迭代
        Order.inorderTraversalRecursive(binaryTree.getRoot());

        //后续遍历 迭代
        Order.postorderTraversalRecursive(binaryTree.getRoot());

        //层序遍历 队列
        Order.levelOrder(binaryTree.getRoot());

        //判断对称二叉树 递归
        Attribute.isSymmetric(binaryTree.getRoot());

        //判断对称二叉树 迭代 普通队列
        Attribute.isSymmetrixRecursive(binaryTree.getRoot());

        //判断对称二叉树 迭代 两端队列
        Attribute.isSymmetrixRecursive2(binaryTree.getRoot());

        //二叉树最大深度
        Attribute.maxDepth(binaryTree.getRoot());
    }
}
