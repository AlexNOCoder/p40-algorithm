package merge_two_sorted_lists_21;

import common.ListNode;

import java.util.List;

/**
 * @program: p40-algorithm
 * @description: 合并两个有序链表
 * @author: lijie
 * @create: 2020-07-02 11:05
 */
public class SolutionByJack {

    public ListNode mergeTwoList(ListNode l1, ListNode l2){
        if (l1 == null){
            return l2;
        }
        else if (l2 == null){
            return l1;
        }
        else if (l1.val < l2.val){
            l1.next = mergeTwoList(l1.next, l2);
            return l1;
        }else {
            l2.next = mergeTwoList(l1, l2.next);
            return l2;
        }
    }

    public ListNode mergeTwoLists(ListNode ll1, ListNode ll2){
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while(ll1 != null && ll2 != null){
            if (ll1.val <= ll2.val){
                prev.next = ll1;
                ll1 = ll1.next;
            }else {
                prev.next = ll2;
                ll2 = ll2.next;
            }
            prev = prev.next;
        }

        //合并后ll1和ll2最多只有一个还未被合并完，直接将链表末尾指向未合并完的链表即可。
        prev.next = ll1 == null ? ll2 :ll1;
        return prehead.next;
    }
}
