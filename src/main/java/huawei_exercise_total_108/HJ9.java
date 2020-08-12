package huawei_exercise_total_108;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HJ9 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String input = sc.next();
            char[] inputChars = input.toCharArray();
            Set<Integer> set = new HashSet<>();
            for(int i=inputChars.length-1;i>=0;i--){
                if(!set.contains(Integer.valueOf(inputChars[i]))){
                    set.add(Integer.valueOf(inputChars[i]));
                    System.out.print(inputChars[i]);
                }
            }

        }
    }
}
