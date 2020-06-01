package add_two_numbers_2;

import common.ListNode;

import java.util.LinkedList;

/**
 * @author : wangcheng
 * @date : 2020年06月01日 16:04
 */
public class SolutionByCdtft {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        LinkedList<Integer> stack1 = new LinkedList<>();
        LinkedList<Integer> stack2 = new LinkedList<>();
        while (l1 != null) {
            stack1.offer(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.offer(l2.val);
            l2 = l2.next;
        }
        LinkedList<Integer> result = new LinkedList<>();
        boolean flag = false;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            Integer num1 = stack1.poll();
            Integer num2 = stack2.poll();
            Integer sum = num1 + num2;
            if (flag) {
                sum += 1;
                flag = false;
            }
            if (sum > 9) {
                result.offer(sum % 10);
                flag = true;
            } else {
                result.offer(sum);
            }
        }
        while (!stack1.isEmpty()) {
            Integer sum = stack1.poll();
            if (flag) {
                sum += 1;
                flag = false;
            }
            if (sum > 9) {
                result.offer(sum % 10);
                flag = true;
            } else {
                result.offer(sum);
            }
        }
        while (!stack2.isEmpty()) {
            Integer sum = stack2.poll();
            if (flag) {
                sum += 1;
                flag = false;
            }
            if (sum > 9) {
                result.offer(sum % 10);
                flag = true;
            } else {
                result.offer(sum);
            }
        }
        ListNode node = null;
        while (!result.isEmpty()) {
            if (node == null) {
                node = new ListNode(result.poll());
            } else {
                ListNode temp = node;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = new ListNode(result.poll());
            }
        }
        if (flag) {
            ListNode temp = node;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new ListNode(1);
        }
        return node;
    }
}
