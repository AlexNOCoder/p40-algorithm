package merge_two_sorted_lists_21;

import common.ListNode;

public class SolutionByAlex {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 ==null){
            return null;
        }
        ListNode result =  new ListNode(0);
        ListNode flag = result;
        while(l1 != null && l2 != null){
            if(l1.val == l2.val){
                flag.next = new ListNode(l1.val);
                flag = flag.next;
                flag.next = new ListNode(l2.val);
                flag = flag.next;
                l1 = l1.next;
                l2 = l2.next;
            }else if(l1.val < l2.val){
                flag.next = new ListNode(l1.val);
                flag = flag.next;
                l1 = l1.next;
            }else{
                flag.next = new ListNode(l2.val);
                flag = flag.next;
                l2 = l2.next;
            }
        }
        if(l2 == null){
            flag.next = l1;
        }
        if(l1 == null){
            flag.next = l2;
        }
        return result.next;
    }
}

