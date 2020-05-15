package add_two_numbers_2;
public class SolutionByAlex {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            return null;
        }
        if(l1 == null && l2 != null){
            return l2;
        }
        if(l1 != null && l2 == null){
            return l1;
        }
        int first_node_sum = l1.val + l2.val;
        int flag = 0;
        ListNode result = new ListNode(0);
        if(first_node_sum > 9){
            result.val = first_node_sum - 10;
            flag =1;
        }else {
            result.val = first_node_sum;
        }
        ListNode cur = result;
        while(l1.next != null && l2.next != null){
            l1 = l1.next;
            l2 = l2.next;
            int sum;
            if(flag == 0){
                sum = l1.val + l2.val;
            }else{
                sum = l1.val + l2.val + 1;
            }
            if(sum > 9){
                ListNode sumNode = new ListNode(sum -10);
                cur.next = sumNode;
                cur = sumNode;
                flag = 1;
            }else{
                ListNode sumNode = new ListNode(sum);
                cur.next = sumNode;
                cur = sumNode;
                flag = 0;
            }

        }
        if(flag == 0){
            if(l1.next == null){
                result.next = l2;
            }
            if(l2.next == null){
                result.next = l1;
            }
        }else{
            if(l1.next == null && l2.next != null){
                l2.val = l2.val +1;
                result.next = l2;
            }
            if(l2.next == null && l1.next != null){
                l1.val = l1.val +1;
                result.next = l1;
            }
            if(l1.next == null && l2.next == null){
                ListNode temp = new ListNode(1);
                temp.next = null;
                cur.next = temp;
            }
        }

        return result;
    }
}

