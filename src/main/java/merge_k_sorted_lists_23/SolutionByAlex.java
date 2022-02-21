package merge_k_sorted_lists_23;

import common.ListNode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class SolutionByAlex {
        // 通过最小堆实现
        public static ListNode mergeKLists(ListNode[] lists) {
            if(lists == null || lists.length == 0){
                return null;
            }
            // 利用一个空的链表头方便我们插入节点
            ListNode fakeHead = new ListNode(0);
            ListNode p = fakeHead;
            // 定义一个最小堆来保存k个链表节点。
            int k = lists.length;
            PriorityQueue<ListNode> heap = new PriorityQueue<>(k,new Comparator<ListNode>(){
                public int compare(ListNode a, ListNode b){
                    return  a.val - b.val;
                }
            });
            // 将k个链表头放到最小堆中
            for(int i=0;i<k;i++){
                if(lists[i] !=null){
                    heap.offer(lists[i]);
                }
            }
            // 从最小堆中将当前最小节点取出，插入到结果链表中
            while(!heap.isEmpty()){
                ListNode node = heap.poll();
                p.next = node;
                p = p.next;
                if(node.next != null){
                    heap.offer(node.next);
                }
            }
            return fakeHead.next;
        }

    // 归并实现 faster
    public  ListNode mergeKLists2(ListNode[] lists){
        if(lists == null || lists.length == 0){
            return null;
        }
        return mergeKLists(lists,0,lists.length-1);
    }

    public ListNode mergeKLists(ListNode[] lists,int low,int high){
          if(low == high) {
                return lists[low];
          }
          // 从中间开始
          int middle = low + (high-low)/2;
          // 然后递归的处理左边和右边的列表，最后合并起来
          return mergeTwoLists(mergeKLists(lists,low,middle),mergeKLists(lists,middle+1,high));
    }
    public ListNode mergeTwoLists(ListNode a,ListNode b){
            if(a == null){
                return b;
            }
            if(b == null){
                return a;
            }
            if(a.val <= b.val){
                a.next = mergeTwoLists(a.next,b);
                return a;
            }
            b.next = mergeTwoLists(a,b.next);
            return b;
    }


    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(2);
        ListNode n6 = new ListNode(6);
        n1.next = n2;
        n3.next = n4;
        n5.next = n6;
        ListNode[] arr = {};
        mergeKLists(arr);
    }
}

