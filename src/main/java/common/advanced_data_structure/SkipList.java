package common.advanced_data_structure;

import java.util.Arrays;
import java.util.Random;

/**
 * @author luoyuntian
 * @program: p40-algorithm
 * @description: 跳表
 * @date 2022-03-08 07:24:14
 */
public class SkipList {
    // 节点个数
    private static final int MAX_LEVEL = 16;
    // 索引的层数
    private int levelCount = 1;
    // 头结点
    private Node head = new Node();
    private Random random = new Random();
    // 查找操作
    public Node find(int value){
        Node p = head;
        for(int i = levelCount -1;i >= 0; --i){
            while(p.next[i] != null && p.next[i].data < value){
                p = p.next[i];
            }
        }
        if(p.next[0] != null && p.next[0].data == value){
            // 找到，则返回原始链表中的节点
            return p.next[0];
        }else {
            return null;
        }
    }
    // 插入操作
    public void insert(int value){
        int level = randomLevel();
        Node newNode = new Node();
        newNode.data = value;
        newNode.maxLevel = level;
        Node update[] = new Node[level];
        for(int i = 0;i < level; --i ){
           update[i] = head;
        }
        Node p = head;
        for(int i = level - 1;i >= 0; --i){
            while(p.next[i] != null && p.next[i].data < value){
                p = p.next[i];
            }
            update[i] = p;
        }

        for(int i = 0;i < level; ++i){
            newNode.next[i] = update[i].next[i];
            update[i].next[i] = newNode;
        }
        if(levelCount < level){
            levelCount = level;
        }

    }
    // 删除操作
    public  void delete(int value){
        Node[] update = new Node[levelCount];
        Node p = head;
        for(int i = levelCount - 1;i >= 0; --i){
            while(p.next[i] != null && p.next[i].data < value){
                p = p.next[i];
            }
            update[i] = p;
        }
        if(p.next[0] != null && p.next[0].data == value){
            for(int i = levelCount - 1;i >= 0; --i){
                if(update[i].next[i] != null && update[i].next[i].data == value){
                    update[i].next[i] = update[i].next[i].next[i];
                }
            }
        }
    }
    // display
    public void display(){
        Node p = head;
        while(p.next[0] != null){
            System.out.println(p.next[0]+" ");
            p = p.next[0];
        }
        System.out.println();
    }

    // 随机函数
    public int randomLevel(){
        int level = 1;
        for(int i = 1;i<MAX_LEVEL;++i){
           if(random.nextInt() % 2 == 1) {
                level ++;
           }
        }
        return level;
    }



    private class Node{
        private int data = -1;
        private Node next[] = new Node[MAX_LEVEL];
        private int maxLevel = 0;

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + Arrays.toString(next) +
                    ", maxLevel=" + maxLevel +
                    '}';
        }
    }
}
