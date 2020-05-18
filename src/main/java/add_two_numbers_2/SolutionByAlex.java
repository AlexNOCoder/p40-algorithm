package add_two_numbers_2;

import common.ListNode;

public class SolutionByAlex {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);

        ListNode l2 = new ListNode(2);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);

        addTwoNumbers(l1,l2);
//          add(l1,2);
    }





        public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if(l1 == null && l2 == null){
                return null;
            }
            if(l1 == null && l2 != null){
                return l2;
            }
            if(l1 != null && l2 == null){
                return l1;
            }
            int flag = 0;
            ListNode result = new ListNode(0);
            ListNode cur = result;
            while(l1 != null && l2 != null){
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
                l1 = l1.next;
                l2 = l2.next;
            }
            if(flag == 0){
                if(l1 == null){
                    cur.next = l2;
                }
                if(l2 == null){
                    cur.next = l1;
                }
            }else{
                if(l1 == null && l2 != null){
                    l2 = add(l2,1);
                    cur.next = l2;
                }
                if(l2 == null && l1 != null){
                    l1 = add(l1,1);
                    cur.next = l1;
                }
                if(l1 == null && l2 == null){
                    ListNode temp = new ListNode(1);
                    temp.next = null;
                    cur.next = temp;
                }
            }

            return result.next;
        }

        public static ListNode add(ListNode oringal,int num){
            int flag =0;
            ListNode current = oringal;
            while(current != null){
                if(flag ==0 ){
                    current.val += num;

                }else {
                    current.val +=1;
                }
                if(current.val <10){
                    return oringal;
                }else {
                    current.val -= 10;
                    flag = 1;
                }
                current = current.next;
            }
            if(flag == 0){
                return  oringal;
            }else {
                ListNode temp = new ListNode(1);
                ListNode cur = oringal;
                while(cur.next != null){
                    cur = cur.next;
                }
                cur.next = temp;
                return  oringal;
            }

        }
}

