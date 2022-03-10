package common.other;

/**
 * @author luoyuntian
 * @program: p40-algorithm
 * @description: 数组实现队列
 * @date 2022-03-01 21:39:28
 */
public class ArrayQueue {
    // 数组：item,数组大小为n
    int[] nums;
    // head表示队头下标
    int head = 0;
    // tail表示队尾下标
    int tail = 0;

    // 申请一个大小为capacity的数组
    public ArrayQueue(int size){
        nums = new int[size];
    }
    //入队
    public boolean enqueue(int n){
        // 如果tail == n表示队列已经满了
        if(tail == nums.length){
           return false;
        }
        nums[tail] = n;
        ++tail;
        return true;
    }
    // 出队
    public int dequeue(){
        // 如果head == tail 表示队列为空
        if(head == tail){
            return 0;
        }
        int ret = nums[head];
        ++head;
        return ret;
    }


}

