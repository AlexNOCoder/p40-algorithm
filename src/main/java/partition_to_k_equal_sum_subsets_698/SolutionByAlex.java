package partition_to_k_equal_sum_subsets_698;

import java.util.*;

public class SolutionByAlex {
    public static void main(String[] args) {
//        int[] nums = {10,10,10,7,7,7,7,7,7,6,6,6};
        int[] nums = {1,2,3,4,7,9,5,6};
        System.out.println(canPartitionKSubsets(nums,3));;
    }

    //todo 只能处理两个以下数据组成
    public static boolean canPartitionKSubsets(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        //计算总数
        int sum = 0;
        for(int i: nums){
            priorityQueue.add(i);
            sum+=i;
        }
        //会被分成多少组
        int splits = sum / k;
        //不能等分则直接返回false
        if(sum %k !=0){
            return false;
        }
        Set<Integer> visited = new HashSet<>();
        //回溯算法找到可能的实现方式

        System.out.println(priorityQueue.poll());
        return true;
    }
}
