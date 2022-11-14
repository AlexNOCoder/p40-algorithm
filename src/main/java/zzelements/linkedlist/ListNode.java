package zzelements.linkedlist;

/**
 * @program: p40-algorithm
 * @description: 链表节点
 * @author: lijie
 * @create: 2022-11-14 21:32
 */
public class ListNode {

    int val;//节点上存储的元素

    ListNode next;//指向下一个节点的指针

    ListNode(int x){
        this.val = x;
        this.next = null;
    }
}
