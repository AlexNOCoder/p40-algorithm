package odd_even_linked_list_328;


import common.ListNode;

import java.util.List;

public class SolutionByAlex {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        oddEvenList(head);
    }


    public static ListNode oddEvenList(ListNode head) {
        if(head == null){
            return null;
        }
        //奇数odd 偶数even
        ListNode oddStart =  head;
        ListNode evenStart = head.next;
        if(evenStart == null){
            return head;
        }
        //最后节点的前一个节点
        ListNode preLast = head;

        //最后节点
        ListNode last = preLast.next;
        //统计链表长度
        int count = 0;
        while(last.next != null){
            last = last.next;
            preLast = preLast.next;
            count++;
        }
        boolean isOdd = count % 2 == 1? true:false;

        if(isOdd){
            ListNode curLast = last;
            //长度为奇数
            while(oddStart != last){
                //奇数节点连接下一个奇数节点
                oddStart.next = oddStart.next.next;
                //奇数指针后移
                oddStart = oddStart.next;
                //保存偶数节点
                ListNode temp = evenStart;
                //evenstart指针后移
                evenStart = evenStart.next.next;
                //将偶数节点放置在最后面
                curLast.next = temp;
                //curLast后移，指向最后节点
                curLast = curLast.next;
                //最后一个节点next置空
                curLast.next = null;

            }
        }else {
            ListNode curLast = preLast;
            //长度为偶数
            while (oddStart != preLast){
                //奇数节点连接下一个奇数节点
                oddStart.next = oddStart.next.next;
                //奇数指针后移
                oddStart = oddStart.next;
                //保存偶数节点
                ListNode temp = evenStart;
                //evenstart指针后移
                evenStart = evenStart.next.next;
                //将偶数节点放置在最后一个节点的前一个位置
                temp.next = curLast.next;
                curLast.next = temp;
                //curLast后移，指向最后节点
                curLast = curLast.next;
            }

        }
        return head;

    }
}
