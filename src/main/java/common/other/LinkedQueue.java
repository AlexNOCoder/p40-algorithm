package common.other;

/**
 * @author luoyuntian
 * @program: p40-algorithm
 * @description: 链表队列
 * @date 2022-03-01 21:44:55
 */
public class LinkedQueue {
    // 链表节点
    private class Node{
        int value;
        LinkedQueue.Node next;
        public Node(int value){
            this.value = value;
        }
    }

    Node head;
    Node tail;
    int size;

    public void enqueue(Node node){
        if(tail == null){
            head = node;
            tail = node;
        }else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public Node dequeue(){
        if(head == null){
            return null;
        }
        Node h = head;
        // 将拉取的节点的下一个节点变成新的表头
        head = head.next;
        // 把旧的表头的下一个节点指向设置为null，便于回收
        h.next = null;
        // 队列为空
        if(head == null){
            tail = null;
        }
        size--;
        return h;
    }

}
