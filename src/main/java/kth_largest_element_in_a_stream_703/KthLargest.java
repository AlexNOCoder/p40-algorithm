package kth_largest_element_in_a_stream_703;

import java.util.PriorityQueue;

/**
 * @author luoyuntian
 * @program: p40-algorithm
 * @description:
 * @date 2022-04-17 21:05:20
 */
public class KthLargest {
//    设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。
//    请实现 KthLargest类：
//    KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
//    int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。
    private PriorityQueue<Integer> queue;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        queue = new PriorityQueue<Integer>();
        for(int i=0;i<nums.length;i++){
            if(i<k){
                // 前k个数直接插入
                queue.offer(nums[i]);
            }else{
                // k+1个数开始，如果nums[i]大于堆顶原始
                if(nums[i] >= queue.peek()){
                    // 加入该数
                    queue.offer(nums[i]);
                    // 踢出最小的一个
                    queue.poll();
                }
            }
        }
    }

    public int add(int val) {
        if(queue.size() < k){
            // 前k个数直接插入
            queue.offer(val);
        }else{
            // k+1个数开始，如果nums[i]大于堆顶原始
            if(val >= queue.peek()){
                // 加入该数
                queue.offer(val);
                // 踢出最小的一个
                queue.poll();
            }
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        int k = 3;
        int[] nums = {4,5,8,2};
        KthLargest kth = new KthLargest(k,nums);
        System.out.println(kth.add(3));
        System.out.println(kth.add(5));
        System.out.println(kth.add(10));
        System.out.println(kth.add(9));
        System.out.println(kth.add(4));

    }
}
