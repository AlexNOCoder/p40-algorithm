package open_the_lock_752;

import java.util.Arrays;
import java.util.List;

public class SolutionByAlex {
    public static void main(String[] args) {
       String []  deadends = {"0201","0101","0102","1212","2002"};
       String target = "0202";
       int openLock = openLock(deadends,target);
        System.out.println(openLock);
    }



    public static int openLock(String[] deadends, String target) {

        List<String> dead = Arrays.asList(deadends);
        if(dead.contains("0000")){
            return -1;
        }
        char[] str = target.toCharArray();
        int count =0;
        for(int i=0;i<str.length;i++){

        }
        if (count > -1){
            return count;
        }else {
            return -1;
        }
    }


}
