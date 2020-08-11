package huawei_exercise_total_108;

import java.util.Scanner;

public class HJ2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String inputStr1 = sc.nextLine().toLowerCase();
            char[] inputStr1Chars = inputStr1.toCharArray();
            char inputChar = sc.nextLine().toLowerCase().charAt(0);
            int count =0;
            for(int i=0;i<inputStr1Chars.length;i++){
                if(inputChar == inputStr1Chars[i]){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
