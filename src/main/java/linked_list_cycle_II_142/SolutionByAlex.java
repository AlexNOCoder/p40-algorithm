package linked_list_cycle_II_142;


import common.ListNode;

import java.util.HashSet;
import java.util.Set;

public class SolutionByAlex {
    //141类似
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while(head != null){
            if(set.contains(head)){
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }
}
