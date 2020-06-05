package remove_linked_list_elements_203;


import common.ListNode;

//虚拟头结点，可以让原本头结点的操作与其他操作一致
public class SolutionByAlex {
    public ListNode removeElements(ListNode head, int val) {
        ListNode header = new ListNode(-1);
        header.next = head;
        ListNode cur = header;
        while(cur.next != null){
            if(cur.next.val == val ){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        return header.next;
    }
}
