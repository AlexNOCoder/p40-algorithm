package task_scheduler_621;

import java.util.*;

public class SolutionByAlex {
    public static int leastInterval(char[] tasks, int n) {

        /**
           * 对于本题，需要得到最优的子问题：需要尽量的少待命
         * 是否是贪心问题？通过选择最远的节点来找到最优子问题，并不是贪心，而是依赖n个子问题的动态规划
           */
        //尝试贪心
//        //任务与任务出现次数集合
//        Map<Character,Integer> charTimes = new HashMap<>();
//        int size = tasks.length;
//        for(int i = 0;i < size;i++){
//            if(charTimes.containsKey(tasks[i])){
//                int tempTimes = charTimes.get(tasks[i]);
//                charTimes.put(tasks[i],tempTimes+1);
//            }else {
//                charTimes.put(tasks[i],1);
//            }
//        }
//
//        class TaskInfo{
//            char task;
//            int index;
//            int times;
//
//            public TaskInfo(char task,int index,int times){
//                this.index = index;
//                this.task = task;
//                this.times = times;
//            }
//
//        }
//        //使用小根堆，每次拿出index最小一个，然后再index+1，然后插入
//        PriorityQueue<TaskInfo> priorityQueue = new PriorityQueue<>(new Comparator<TaskInfo>() {
//            @Override
//            public int compare(TaskInfo o1, TaskInfo o2) {
//                return o1.index - o2.index;
//            }
//        });
//        Set<Map.Entry<Character, Integer>> entries = charTimes.entrySet();
//        for(Map.Entry<Character, Integer> en:entries){
//            priorityQueue.offer(new TaskInfo(en.getKey(),-1,en.getValue()));
//        }
//        List<Character> result = new ArrayList<>();
//        int index =0;
//        int coust =0;
//        while(!priorityQueue.isEmpty()){
//            TaskInfo temp = priorityQueue.poll();
//            System.out.println(temp.task);
//            int lastIndex = result.lastIndexOf(temp.task);
//            //计算此次选择耗时
//            if(lastIndex < 0 || index - lastIndex > n){
//                coust ++;
//                System.out.println("耗时："+1);
//            }else {
//                int sleep = n - (index - lastIndex) +1;
//                coust = coust+sleep+1;
//                System.out.println("耗时："+(( n - (index - lastIndex)+1)+1));
//                for(int j=0;j<sleep;j++){
//                    result.add('$');
//                    index++;
//                }
//            }
//
//            result.add(temp.task);
//            temp.index = index;
//            temp.times = temp.times -1;
//            index++;
//            if(temp.times >0){
//                priorityQueue.offer(temp);
//            }
//
//        }
//        return coust;

        return 0;
    }

    public static void main(String[] args) {
        char[] test1 = {'A','A','A','A','A','A','B','C','D','E','F','G'};
//
//
//        leastInterval(test1,2);
//        char[] test1 = {'A','A','A','B','B','B'};


        System.out.println(leastInterval(test1,2));
    }
}


