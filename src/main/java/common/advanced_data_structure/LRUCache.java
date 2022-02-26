package common.advanced_data_structure;

import java.util.HashMap;

/**
 * @author luoyuntian
 * @program: p40-algorithm
 * @description: LRU内存淘汰算法
 * @date 2022-02-26 15:39:52
 */
public class LRUCache {

    // 节点
    public class Node{
        public int key;
        public int value;
        public Node last;
        public Node next;
        public Node(int k,int v){
            key = k;
            value= v;
        }
    }
    // 双向链表

    public class NodeDoubleLinkedList{
        private Node head;
        private Node tail;
        public NodeDoubleLinkedList(){
            head = null;
            tail = null;
        }
        // 增加节点
        public  void addNode(Node newNode){
            if(newNode == null){
                return;
            }
            if(head == null){
                head = newNode;
                tail = newNode;
            }else {
                tail.next = newNode;
                newNode.last = tail;
                tail = newNode;
            }
        }
        // 删除尾结点，
        // 一定能保证x就在双向链表上
        // 把x之前和x之后的节点之间重连
        // 把x放到尾巴上去
        public void moveNodeToTail(Node x){
            // x已经是尾巴
            if(tail == x){
                return;
            }
            // x不是尾巴，x右边一定有节点不为空
            if(head == x){
                // x前面没有节点，x直接去尾巴，head要往下走
                head = x.next;
                head.last = null;
            }else {
                // x有前也有后
                x.last.next = x.next;
                x.next.last = x.last;
            }
            // x成为新尾巴
            x.last = tail;
            x.next = null;
            tail.next = x;
            tail = x;
        }
        // 满了，移除头
        public Node removeHead(){
            // 没节点
            if(head == null){
                return null;
            }
            Node res = head;
            // 只有一个节点
            if(head == tail){
                head = null;
                tail = null;
            }else {
                // 不止一个节点
                head = res.next;
                res.next = null;
                head.last = null;
            }
            return res;
        }
    }

    public class MyCache{
        private HashMap<Integer,Node> keyNodeMap;
        private NodeDoubleLinkedList nodeList;
        private final int capacity;

        public MyCache(int cap){
            keyNodeMap = new HashMap<>();
            nodeList = new NodeDoubleLinkedList();
            capacity = cap;
        }

        public int get(int key){
            if(keyNodeMap.containsKey(key)){
                Node res = keyNodeMap.get(key);
                nodeList.moveNodeToTail(res);
                return res.value;
            }
            return -1;
        }

        public void set(int key,int value){
            // 更新以后，也要将节点移动到尾部
            if(keyNodeMap.containsKey(key)){
                Node node = keyNodeMap.get(key);
                node.value = value;
                nodeList.moveNodeToTail(node);
            }else {
                // 插入操作
                Node newNode = new Node(key,value);
                keyNodeMap.put(key,newNode);
                nodeList.addNode(newNode);
                // 移除最早的头部的节点
                if(keyNodeMap.size() == capacity +1){
                    removeMostUnusedCache();
                }
            }
        }

        public void removeMostUnusedCache(){
            Node removeNode = nodeList.removeHead();
            keyNodeMap.remove(removeNode.key);
        }

    }
}
