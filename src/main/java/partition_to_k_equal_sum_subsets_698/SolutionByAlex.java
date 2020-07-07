package partition_to_k_equal_sum_subsets_698;

import java.util.PriorityQueue;

public class SolutionByAlex {
    public static void main(String[] args) {
        int[] nums = {10,10,10,7,7,7,7,7,7,6,6,6};
        System.out.println(canPartitionKSubsets(nums,3));;
    }

    //todo 只能处理两个以下数据组成
    public static boolean canPartitionKSubsets(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue1 = new PriorityQueue<>();
        PriorityQueue<Integer> priorityQueue2 = new PriorityQueue<>();
        int sum=0;
        for(int i=0;i<nums.length;i++){
            priorityQueue1.offer(nums[i]);
            sum += nums[i];
        }
        int avg = sum/k;
        for(int j=0;j<nums.length;j++){
            priorityQueue2.offer(avg-nums[j] == 0 ? avg : avg-nums[j] );
        }
        while(!priorityQueue1.isEmpty()){
            if(!priorityQueue1.poll().equals(priorityQueue2.poll())){
                return false;
            }
        }
        return true;
    }
}
