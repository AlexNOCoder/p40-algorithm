package common.other;

/**
 * @author luoyuntian
 * @program: p40-algorithm
 * @description: 手写hashMap
 * @date 2022-03-01 21:51:10
 */
public class MyHashMap {
    // 节点
    private class Node{
        String key;
        String value;
        Node next;

        public Node(String key,String value,Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
    // 单链表
    private class ListNode{
        Node head;
        public void addNode(String key,String value){
            if(head == null){
                return;
            }
            // 创建节点
            Node node = new Node(key,value,null);
            // 临时变量
            Node tmp = head;

            while(true){
                // key相同覆盖值，从head开始
                if(key.equals(tmp.key)){
                    tmp.value = value;
                }
                if(tmp.next == null){
                    break;
                }

                tmp = tmp.next;
            }
            // 在循环外挂载最后一个节点
            tmp.next = node;
        }

        public String getValue(String key){
            if(head == null){
                return null;
            }
            if(head.next == null){
                return head.value;
            }else {
                Node tmp = head;
                while(tmp != null){
                    // 找到匹配的key
                    if(key.equals(tmp.key)){
                        return tmp.value;
                    }
                    tmp = tmp.next;
                }
                return null;
            }
        }
    }

    // 初始化数组
    ListNode[] map = new ListNode[8];
    // ListNode的个数
    int size;

    public void put(String key,String value){
        // 负载因子 0.75
        if(size >= map.length * 0.75){
            System.out.println("扩容map");
            return;
        }
        // 计算索引数组下标
        int index = Math.abs(key.hashCode())%map.length;
        // 获取该下标处的ListNode
        ListNode ln = map[index];
        // 该下标处无值
        if(ln == null){
            // 创建单链表
            ListNode lnNew = new ListNode();
            // 创建头结点
            Node head = new Node(key,value,null);
            // 挂载头结点
            lnNew.head = head;
            // 将单链表放数组里
            map[index] = lnNew;
            size++;
        }else {
            // 该下标有值，hash碰撞
            ln.addNode(key,value);
        }
    }

    public String get(String key){
        int index = Math.abs(key.hashCode())%map.length;
        ListNode ln = map[index];
        if(ln == null){
           return null;
        }
        return ln.getValue(key);
    }


}
