package common.other;

/**
 * @author luoyuntian
 * @program: p40-algorithm
 * @description: 链表实现栈
 * @date 2022-03-01 21:33:48
 */
public class LinkedStack {
    // 链表节点
    private class Node{
        int value;
        Node next;
        public Node(int value){
            this.value = value;
        }
    }
    int size;
    Node head;

    public LinkedStack(){
        head = null;
        size = 0;
    }

    // 头插法
    public void push(Node node){
        if(size == 0){
            head = node;
        }else{
            node.next = head;
            head = node;
        }
        size++;
    }

    public Node pop(){
        if(size > 0){
            Node oldHead = head;
            head = head.next;
            size--;
            return oldHead;
        }else {
            return null;
        }
    }


}
