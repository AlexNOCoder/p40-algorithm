package huawei_exercise_total_108;

import java.util.Scanner;

public class HJ6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int input = sc.nextInt();
            for(int i=2;i<= input;i++){
                while(input%i == 0){
                    System.out.print(i);
                    System.out.print(" ");
                    input = input / i;
                }
            }
        }
    }


}
