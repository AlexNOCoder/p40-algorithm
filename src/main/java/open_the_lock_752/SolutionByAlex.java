package open_the_lock_752;

import java.util.*;

public class SolutionByAlex {
    public static void main(String[] args) {
       String []  deadends = {"0201","0101","0102","1212","2002"};
       String target = "0202";
       int openLock = openLock(deadends,target);
        System.out.println(openLock);
    }


    // 某一个状态的上一种情况有八种,每一位都可以+1和-1
    public static int openLock(String[] deadends, String target) {
        List<String> deads =  Arrays.asList(deadends);
        HashSet<String> hashSet = new HashSet<>(deads);
        if(deads.contains("0000")){
            return -1;
        }
        Queue<String> queue = new LinkedList<>();
        queue.add("0000");
        int count = 0;
        while(!queue.isEmpty()){
            int size =  queue.size();
            while(size -- >0){
                String temp = queue.poll();
                if(target.equals(temp)){
                    return count;
                }
                char[] chars = temp.toCharArray();
                for(int index = 0;index <4 ;index++){
                    int i = chars[index] - '0';
                    //-1
                    chars[index] = (char) ('0' +(i + 9)%10);
                    String s = new String(chars);
                    if(!hashSet.contains(s)){
                        queue.offer(s);
                        hashSet.add(s);
                    }
                    //+1
                    chars[index] = (char) ('0' +(i + 11)%10);
                    s = new String(chars);
                    if(!hashSet.contains(s)){
                        queue.offer(s);
                        hashSet.add(s);
                    }
                    //还原
                    chars[index] = (char) ('0' +i);
                }
            }
            count ++ ;
        }

        return -1;
    }


}
