package huawei_exercise_total_108;

import java.util.Scanner;

public class HJ3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String input1 = sc.nextLine();
            String input2 = sc.nextLine();
            printStr(input1);
            printStr(input2);
        }
    }

    public static void printStr(String input){
        if(input.length() <= 8){
            System.out.println(lastFix(input));
        }else {
            int i=0,j=8;
            for(;j<input.length();){
                System.out.println(input.substring(i,j));
                i = j;
                j += 8;
            }
            if( i< input.length()){
                System.out.println(lastFix(input.substring(i)));
            }
        }

    }

    public static String lastFix(String input){
        String lastFixStr ="";
        for(int i=0;i<(8-input.length());i++){
            lastFixStr += "0";
        }
        return input+lastFixStr;

    }

}
