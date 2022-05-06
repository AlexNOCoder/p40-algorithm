package populating_next_right_pointers_in_each_node_116;

public class SolutionByAlex {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
    public Node connect(Node root) {
        if(root == null){
            return null;
        }
        preOrder(root.left,root.right);
        return root;
    }
    public void preOrder(Node left, Node right){
        if(left == null || right == null){
            return ;
        }
        preOrder(left.left,left.right);
        preOrder(left.right,right.left);
        preOrder(right.left,right.right);
        left.next = right;
    }
}
