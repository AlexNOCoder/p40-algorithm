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

    static Integer size;
    static ListNode dummyNode;
    public static Integer get(int index){
        if (index < 0 || index >= size){
            return -1;
        }
        ListNode currentNode = dummyNode;
        //包含一个虚拟节点，所有查找第index+1个节点
        for (int i = 0; i <= index; i ++){
            currentNode = currentNode.next;
        }
        return currentNode.val;
    }

    public static void addAtHead(int val){
        addAtHead(0, val);
    }

    public static void addAtTail(int val){
        addAtHead(size, val);
    }

    public static void addAtHead(int index, int val){
        if (index > size){return;}
        if (index < 0){
            index = 0;
        }
        size ++;
        //找到要插入节点的前驱
        ListNode pred = dummyNode;
        for (int i = 0; i < index; i ++){
            pred = pred.next;
        }
        ListNode toAdd = new ListNode(val);
        toAdd.next = pred.next;
        pred.next = toAdd;
    }

    //删除第index个节点
    public static void deleteAtIndex(int index){
        if (index < 0 || index >= size){
            return;
        }
        size--;
        if (index == 0){
            dummyNode = dummyNode.next;
            return;
        }
        ListNode pred = dummyNode;
        for (int i = 0; i < index; i ++){
            pred = pred.next;
        }
        pred.next = pred.next.next;
    }
}
