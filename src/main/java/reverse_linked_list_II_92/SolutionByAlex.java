package reverse_linked_list_II_92;

import common.ListNode;

public class SolutionByAlex {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left ==1){
            return reverseN(head,right);
        }
        head.next = reverseBetween(head.next,left-1,right-1);
        return head;
    }

    ListNode successor = null;
    //翻转链表前n
    public ListNode reverseN(ListNode head,int m){
        if(m == 1){
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next,m-1);
        head.next.next = head;
        head.next = successor;
        return last;
    }
    //翻转整个链表
    public ListNode reverse(ListNode head){
        if(head.next == null){
            return head;
        }
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}
