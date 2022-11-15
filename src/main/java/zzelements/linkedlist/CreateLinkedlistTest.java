package zzelements.linkedlist;

/**
 * @program: p40-algorithm
 * @description: 链表测试
 * @author: lijie
 * @create: 2022-11-14 22:11
 */
public class CreateLinkedlistTest {

    public static void main(String[] args){

        //移除链表元素
        ListNode head = new ListNode(1);
        ListNode one = new ListNode(2);
        ListNode two = new ListNode(6);
        ListNode three = new ListNode(3);
        head.next = one;
        one.next = two;
        two.next = three;
//        Operate.removeElements(head, 6);
        Operate.reverse(head);

    }
}
