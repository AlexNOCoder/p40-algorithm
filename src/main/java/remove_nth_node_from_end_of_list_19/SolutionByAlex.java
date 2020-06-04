package remove_nth_node_from_end_of_list_19;


import common.ListNode;

public class SolutionByAlex {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head;
        ListNode last = head;
        for(int i=0;i<n;i++){
            last = last.next;
        }
        if(last == null){
            return head.next;
        }
        while(last.next != null){
            last = last.next;
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return head;
    }
}
