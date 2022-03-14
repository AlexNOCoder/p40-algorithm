package common.other;

/**
 * @author luoyuntian
 * @program: p40-algorithm
 * @description: 红黑树
 *
 * 特点：
 * 1.如果左子树不为空，则左子树上所有节点的值均小于根节点的值
 * 2.如果右子树不为空，则右子树上所有节点的值均大于根节点的值
 * 3.左右子树也都是二叉查找树
 * 4.每个节点要么是黑色，要么是红色
 * 5.根节点是黑色
 * 6.每个叶子节点都是黑色的空节点(NIL节点),一般会省略该节点
 * 7.如果一个节点是红色的，则它的子节点必须是黑色的(父子不能同为红色)
 * 8.从任一结点到其每个叶子的所有路径都包含相同数目的黑色结点(平衡的关键)
 * 9.新插入结点默认为红色，插入后需要校验红黑树是否符合规则，不符合则需要平衡
 *
 * @date 2022-03-02 08:04:15
 */
public class RedBlackTree {
    private class RedBlackTreeNode{
        private int key;
        private boolean isBlack;
        private RedBlackTreeNode left;
        private RedBlackTreeNode right;
        private RedBlackTreeNode parent;

        public RedBlackTreeNode(int key){
            this.key = key;
            // 新节点默认为红色
            this.isBlack = false;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public boolean isBlack() {
            return isBlack;
        }

        public void setBlack(boolean black) {
            isBlack = black;
        }

        public RedBlackTreeNode getLeft() {
            return left;
        }

        public void setLeft(RedBlackTreeNode left) {
            this.left = left;
        }

        public RedBlackTreeNode getRight() {
            return right;
        }

        public void setRight(RedBlackTreeNode right) {
            this.right = right;
        }

        public RedBlackTreeNode getParent() {
            return parent;
        }

        public void setParent(RedBlackTreeNode parent) {
            this.parent = parent;
        }

        @Override
        public String toString() {
            return "RedBlackTreeNode{" +
                    "key=" + key +
                    ", color=" + (isBlack == true ? "BLACK":"RED")+
                    '}';
        }
    }

    // 根节点
    RedBlackTreeNode root;

    /**
     * @param node
     * @return void
     * @author luoyuntian
     * @describe: 遍历节点
     * @date 2022/3/2 8:08 上午
     */
    public void list(RedBlackTreeNode node){
        if(node == null){
           return;
        }
        // 叶子
        if(node.getLeft() == null && node.getRight() == null){
            System.out.println(node);
            return;
        }
        System.out.println(node);
        // 递归左孩子
        list(node.getLeft());
        // 递归右孩子
        list(node.getRight());
    }

    /**
     * @param key
     * @return void
     * @author luoyuntian
     * @describe: 插入节点
     * @date 2022/3/2 8:09 上午
     */
    public void insert(int key){
        RedBlackTreeNode node = new RedBlackTreeNode(key);
        if(root == null){
            // 根节点为黑色
            node.setBlack(true);
            node = node;
            return;
        }
        RedBlackTreeNode parent = root;
        RedBlackTreeNode son = null;
        if(key <= parent.getKey()){
            son = parent.getLeft();
        }else{
            son = parent.getRight();
        }
        // 找到位置
        while(son != null){
            parent = son;
            if(key <= parent.getKey()){
                son = parent.getLeft();
            }else {
                son = parent.getRight();
            }
        }
        // 将父节点连接到node
        if(key <= parent.getKey()){
            parent.setLeft(node);
        }else {
            parent.setRight(node);
        }
        // 设置父节点
        node.setParent(parent);
        // 自平衡
        balanceInsert(node);
    }

    /**
     * @param
     * @return void
     * @author luoyuntian
     * @describe: 自平衡
     * @date 2022/3/2 8:10 上午
     */

    private void balanceInsert(RedBlackTreeNode node){
        RedBlackTreeNode father;
        RedBlackTreeNode grandFather;

        while((father = node.getParent()) != null && father.isBlack() == false){
            grandFather = father.getParent();
            // 父节点为祖父的左孩子
            if(grandFather.getLeft() == father){
                RedBlackTreeNode uncle = grandFather.getRight();
                if(uncle != null && uncle.isBlack() == false){
                    setBlack(father);
                    setBlack(uncle);
                    setRed(grandFather);
                    node = grandFather;
                    continue;
                }
                if(node == father.getRight()){
                    // 左旋
                    leftRotate(father);
                    RedBlackTreeNode tmp = node;
                    node = father;
                    father = tmp;
                }
                setBlack(father);
                setRed(grandFather);
                // 右旋
                rightRotate(grandFather);
            }
            // 父为祖右孩子
            else{
                RedBlackTreeNode uncle = grandFather.getLeft();
                if(uncle != null && uncle.isBlack() == false){
                    setBlack(father);
                    setBlack(uncle);
                    setRed(grandFather);
                    node = grandFather;
                    continue;
                }
                if(node == father.getLeft()){
                    // 右旋
                    rightRotate(father);
                    RedBlackTreeNode tmp = node;
                    node = father;
                    father = tmp;
                }
                setBlack(father);
                setRed(grandFather);
                // 左旋
                leftRotate(grandFather);
            }
        }
        setBlack(root);
    }

    /**
     * @param node
     * @return void
     * @author luoyuntian
     * @describe: 左旋
     * @date 2022/3/2 8:11 上午
     */

    private void leftRotate(RedBlackTreeNode node){
        RedBlackTreeNode right = node.getRight();
        RedBlackTreeNode parent = node.getParent();
        if(parent == null){
            root = right;
            right.setParent(null);
        }else{
            if(parent.getLeft() == null && parent.getLeft() == node){
                parent.setLeft(right);
            }else {
                parent.setRight(right);
            }
            right.setParent(parent);
        }
        node.setParent(right);
        node.setRight(right.getLeft());
        if(right.getLeft() != null){
            right.getLeft().setParent(node);
        }
        right.setLeft(node);
    }

    /**
     * @param node
     * @return void
     * @author luoyuntian
     * @describe: 右旋
     * @date 2022/3/2 8:11 上午
     */

    private void rightRotate(RedBlackTreeNode node){
        RedBlackTreeNode left = node.getLeft();
        RedBlackTreeNode parent = node.getParent();

        if(parent == null){
            root = left;
            left.setParent(null);
        }else{
            if(parent.getLeft() != null && parent.getLeft() == node){
                parent.setLeft(left);
            }else{
                parent.setRight(left);
            }
            left.setParent(parent);
        }
        node.setParent(left);
        node.setLeft(left.getRight());
        if(left.getRight() != null){
            left.getRight().setParent(node);
        }
        left.setRight(node);
    }

    private void setBlack(RedBlackTreeNode node){
        node.setBlack(true);
    }

    private void setRed(RedBlackTreeNode node){
        node.setBlack(false);
    }
}
