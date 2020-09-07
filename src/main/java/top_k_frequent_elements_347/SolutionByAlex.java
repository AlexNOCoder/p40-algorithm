package top_k_frequent_elements_347;

import java.util.*;

public class SolutionByAlex {
    public static void main(String[] args) {

    }


    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] result = new int[k];
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else {
                map.put(nums[i],1);
            }
        }
        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
        PriorityQueue<InnerMap> priorityQueue = new PriorityQueue<>(new Comparator<InnerMap>() {
            @Override
            public int compare(InnerMap o1, InnerMap o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        for(Map.Entry entry:set){
            priorityQueue.offer(new InnerMap((Integer) entry.getKey(),(Integer) entry.getValue()));
        }
        for(int j=0;j<k;j++){
            result[j] = priorityQueue.poll().getKey();
        }

        return result;
    }

    class InnerMap{
        private Integer key;
        private Integer value;

        public InnerMap(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public Integer getKey() {
            return key;
        }

        public void setKey(Integer key) {
            this.key = key;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }
    }
}
