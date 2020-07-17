package is_same_tree_100;

import common.TreeNode;

import java.util.ArrayDeque;

/**
 * @program: p40-algorithm
 * @description: 判断是否相同的树
 * @author: lijie
 * @create: 2020-07-06 09:53
 */
public class SolutionByJack {
    public boolean isSameTree(TreeNode p, TreeNode q){
        //p and q are both null
        if (p == null && q == null) return true;
        //one of p and q is null
        if (q == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
    }


    public boolean check(TreeNode p, TreeNode q){
        //p and q are null
        if (p == null && q == null) return true;
        //one of p and q is null
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return true;
    }

    public boolean isSameTree1(TreeNode p, TreeNode q){
        if (p == null && q == null) return true;
        if (!check(p, q)) return false;

        //init deques
        ArrayDeque<TreeNode> deqP = new ArrayDeque<TreeNode>();
        ArrayDeque<TreeNode> deqQ = new ArrayDeque<TreeNode>();
        deqP.addLast(p);
        deqQ.addLast(q);

        while(!deqP.isEmpty()){
            p = deqP.removeFirst();
            q = deqQ.removeFirst();

            if (!check(p, q)) return false;
            if (p != null){
                //in Java nulls are not allowed in Deque
                if (!check(p.left, q.left)) return false;
                if (p.left != null){
                    deqP.addLast(p.left);
                    deqQ.addLast(q.left);
                }
            }
        }
        return true;
    }

    //1.如何把二叉树所有的节点中的值加一
    void plusOne(TreeNode root){
        if (root == null) return;
        root.val += 1;

        plusOne(root.left);
        plusOne(root.right);
    }

    //2.如何判断两颗二叉树是否完全相同
    boolean isSameTree2(TreeNode root1, TreeNode root2){
        //为空的话，显然相同
        if (root1 == null && root2 == null) return true;
        //一个为空，一个非空，显然不同
        if (root1 == null || root2 == null) return false;
        //两个都非空，但val不同也不行
        if (root1.val != root2.val) return false;

        //root1和root2的该比的都比完了
        return isSameTree2(root1.left, root2.left) && isSameTree2(root1.right, root2.right);
    }

    //二叉搜索树的相关操作、
    //零，判断BST合法性
    boolean isValidBST(TreeNode root){
        if (root == null) return true;
        if (root.left != null && root.val <= root.left.val) return false;
        if (root.right != null && root.val >= root.right.val) return false;

        return isValidBST(root.left) && isValidBST(root.right);
    }
    //上面这个算法有错误，root需要做的不只是和左右子节点比较，而是要和整个左子树和右子树的所有节点比较
    //这种情况，我们可以使用辅助函数，增加函数参数列表，在参数中携带额外信息。
    Boolean isValidBST1(TreeNode root){
        return isValidBST(root, null, null);
    }

    boolean isValidBST(TreeNode root, TreeNode min, TreeNode max){
        if (root == null) return true;
        if (min != null && root.val <= min.val) return false;
        if (max != null && root.val >= max.val) return false;
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

    //在BST中查找一个数是否存在
    boolean isInBST(TreeNode root, int target){
        if (root == null) return false;
        if (root.val == target) return true;

        return isInBST(root.left, target) || isInBST(root.right, target);
    }

    //优化
    //在BST中插入一个数
    //对数据结构的操作无非就是遍历+访问，遍历就是找，访问就是改。具体到这个问题，插入一个数
    //就是先找到插入位置，然后进行插入操作。
    //上一个问题，总结了BST中的遍历框架，
    TreeNode insertIntoBST(TreeNode root, int val){
        //找到空位置插入新节点
        if (root == null) return new TreeNode(val);
        //if(root.val == val)
        //BST中一般不会插入已存在的元素
        if (root.val < val)
            root.right = insertIntoBST(root.right, val);
        if (root.val > val)
            root.left = insertIntoBST(root.left, val);
        return root;
    }

    //在BST中删除一个数
    //跟插入操作类似，先“找”再“改”。先把框架写出来
    TreeNode deleteNode(TreeNode root, int key){
        if (root.val == key){
            //找到了，进行删出
        }else if (root.val > key){
            root.left = deleteNode(root.left, key);
        }else if (root.val < key){
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    //找到目标节点了，比方说节点A，如何删除这个节点，这是难点。因为删除节点的同时不能破坏BST的性质。

}
