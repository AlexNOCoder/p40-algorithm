package task_scheduler_621;

import java.util.*;

public class SolutionByAlex {
    public static int leastInterval(char[] tasks, int n) {
        int size = tasks.length;
        //记录每次选择的任务
        List<Character> choosed = new ArrayList<>();
        //任务与任务出现次数集合
        Map<Character,Integer> charTimes = new HashMap<>();
        for(int i = 0;i < size;i++){
            if(charTimes.containsKey(tasks[i])){
                int tempTimes = charTimes.get(tasks[i]);
                charTimes.put(tasks[i],tempTimes+1);
            }else {
                charTimes.put(tasks[i],1);
            }
        }
        int coust =0;
        //从小到大更新f[]
        for(int k=0;k<size;k++){
            char temp = '$';
            int tempMinCost = Integer.MAX_VALUE;
            int tempDelay = 0;
            for(Character c:charTimes.keySet()){
                int lastIndex = choosed.lastIndexOf(c);
                int tmepCost = 0;
                int sleep = 0;
                //计算此次选择耗时
                if(lastIndex < 0 || k -lastIndex -n > 1){
                    System.out.println(c+" :不需要delay,lastindex: "+lastIndex+" ;i: "+k);
                    tmepCost = 1;
                }else {
                    sleep = lastIndex + n - k + 1;
                    System.out.println(c+" :需要delay： "+sleep+",lastIndex: "+lastIndex+" ;i: "+k);
                    tmepCost = sleep+1;
                }

                if(tmepCost < tempMinCost){
                    tempMinCost = tmepCost;
                    temp = c;
                    tempDelay = sleep;
                }
            }
            for(int j=0;j<tempDelay;){
                tempDelay--;
                choosed.add('%');
            }
            choosed.add(temp);
            pirntArr(choosed);
            System.out.println("choosed: " +temp +" tempMinCost: "+tempMinCost);
            int nowTimes = charTimes.get(temp) -1;
            if(nowTimes <1){
                charTimes.remove(temp);
            }else {
                charTimes.put(temp,nowTimes);
            }
            System.out.println("===================");
        }
        System.out.println();
        return choosed.size();

//        尝试贪心，最远距离，最多次数
        //任务与任务出现次数集合
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
//            int indexOutBound;
//            int times;
//
//            public TaskInfo(char task,int indexOutBound,int times){
//                this.indexOutBound = indexOutBound;
//                this.task = task;
//                this.times = times;
//            }
//
//        }
//
//        Comparator<TaskInfo> comparator = new Comparator<TaskInfo>() {
//            @Override
//            public int compare(TaskInfo o1, TaskInfo o2) {
//
//                if (o1.indexOutBound != o2.indexOutBound) {
//                    return o1.indexOutBound - o2.indexOutBound;
//                } else {
//                    return o2.times - o1.times;
//                }
//
//            }
//        };

//        Set<Map.Entry<Character, Integer>> entries = charTimes.entrySet();
//        for(Map.Entry<Character, Integer> en:entries){
//            priorityQueue.offer(new TaskInfo(en.getKey(),0,en.getValue()));
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
//            result.add(temp.task);
//            if(index - lastIndex > n ){
//                temp.indexOutBound = 0;
//            }else {
//                temp.indexOutBound = 1;
//            }
//            temp.times = temp.times -1;
//            index++;
//            if(temp.times >0){
//                priorityQueue.offer(temp);
//            }
//
//        }


//        return 0 ;


    }

    public static void main(String[] args) {
        char[] test1 = {'A','A','A','A','A','A','B','C','D','E','F','G'};
//
//
//        leastInterval(test1,2);
//        char[] test1 = {'A','A','A','B','B','B'};


        System.out.println(leastInterval(test1,2));
    }

    public static void pirntArr(List<Character> cList){
        StringBuilder s = new StringBuilder();
        for(Character c:cList){
            s.append(c);
            s.append(" ");
        }
    }

}


