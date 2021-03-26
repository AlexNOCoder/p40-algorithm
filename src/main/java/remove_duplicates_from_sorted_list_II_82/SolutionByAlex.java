package remove_duplicates_from_sorted_list_II_82;

import common.ListNode;

public class SolutionByAlex {
//    存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
//
//    返回同样按升序排列的结果链表。


    public static ListNode duplicateNode(ListNode head){
        if (head == null) {
            return head;
        }
        ListNode pre = new ListNode(0, head);
        ListNode cur = pre;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                //暂存当前值，该节点被删掉后还需要用到该点的值
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }

        return pre.next;

    }
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        ListNode head = duplicateNode(node1);

        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }

    }
}
