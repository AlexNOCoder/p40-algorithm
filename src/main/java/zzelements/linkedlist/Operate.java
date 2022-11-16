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

    //翻转链表 双指针
    //首先定义一个cur指针指向头节点，pre指针指向null；用temp指针将cur.next保存
    public static ListNode reverse(ListNode head){
        ListNode temp;//保存cur的下一个节点
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null){
            temp = cur.next;//保存cur的下一个节点
            cur.next = pre;//翻转操作
            //跟新cur和pre指针
            pre = cur;
            cur = temp;
        }
        System.out.println("翻转链表：" + pre);
        return pre;
    }
    //翻转链表递归，逻辑和双指针一样写法不一样。
    public static ListNode reverseList(ListNode head){
        return reverse(null, head);
    }

    public static ListNode reverse(ListNode pre, ListNode cur){
        if (cur == null){return pre;}
        ListNode temp = null;
        temp = cur.next;//保存下一个节点
        cur.next = pre;//翻转
        //跟新pre，cur位置
        return reverse(cur, temp);
    }

    //两两交换链表中的节点
    //本题关键是画图，并理清操作步骤。写对结束条件。
    public static ListNode swapPairs(ListNode head){
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode pre = dummyNode;

        while (pre.next != null && pre.next.next != null){
            ListNode temp = head.next.next;
            pre.next = head.next;
            head.next.next = head;
            head.next = temp;
            pre = head;
            head = head.next;
        }
        return dummyNode.next;
    }

    //删除链表的倒数第n个节点
    public static ListNode removeNthFromEnd(ListNode head, int n){
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        ListNode fastIndex = dummyNode;
        ListNode slowIndex = dummyNode;

        for (int i = 0; i < n; i ++){
            fastIndex = fastIndex.next;
        }

        while (fastIndex.next != null){
            fastIndex = fastIndex.next;
            slowIndex = slowIndex.next;
        }

        slowIndex.next = slowIndex.next.next;
        return dummyNode.next;
    }

    //链表相交
    //求两个链表交点节点的指针，交点不是数字相等，而是指针相等。
    public static ListNode getIntersectionNode(ListNode A, ListNode B){
        ListNode curA = A;
        ListNode curB = B;
        int lenA = 0, lenB = 0;
        while (curA != null){
            lenA ++;
            curA = curA.next;
        }
        while (curB != null){
            lenB ++;
            curB = curB.next;
        }
        curA = A;
        curB = B;
        //让curA为长链表的头，lenA为其长度
        if (lenB > lenA){
            //1.swap(lenA, lenB)
            int tempLen = lenA;
            lenA = lenB;
            lenB = tempLen;
            //2.swap(curA,curB)
            ListNode tempNode = curA;
            curA = curB;
            curB = tempNode;
        }
        //求长度差
        int gap = lenA - lenB;
        //让curA和curB末尾位置对齐
        while (gap -- > 0){
            curA = curA.next;
        }
        //遍历遇到相同就返回
        while (curA != null){
            if (curA == curB){return curA;}
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }

}
