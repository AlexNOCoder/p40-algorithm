package merge_nodes_in_between_zeros_2181;

import common.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class SolutionByAlex {
    public static ListNode mergeNodes(ListNode head) {
        ListNode res = new ListNode();
        head = head.next;
        while(head != null){
            int temp =0;
            while(head !=null && head.val !=0){
                temp += head.val;
                head = head.next;
            }
            res.next = new ListNode(temp);
            head = head.next;
        }
        return res.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(3);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(0);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next= new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next.next = new ListNode(0);
        mergeNodes(head);

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2-o1;
                    }
                }
        );
        Stack<Integer> stack = new Stack<>();
    }
}

