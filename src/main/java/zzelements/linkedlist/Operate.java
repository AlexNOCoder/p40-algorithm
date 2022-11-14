package zzelements.linkedlist;

/**
 * @program: p40-algorithm
 * @description: 处理
 * @author: lijie
 * @create: 2022-11-14 22:13
 */
public class Operate {

    public static ListNode removeElements(ListNode head, int val){
        //生成虚拟节点
        ListNode dummyHead = new ListNode(0);
        //将虚拟节点放在头节点前
        dummyHead.next = head;

        //设置指针指向虚拟节点
        ListNode prev = dummyHead;
        //判断当前节点的后继节点是否为null
        while (prev.next != null){
            if (prev.next.val == val){
                prev.next = prev.next.next;
            }else {
                //指针向前
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }
}
