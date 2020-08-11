package huawei_exercise_total_108;

import java.util.Scanner;

public class HJ15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int count = 0;
            int input = sc.nextInt();
            if(input == 0 ){
                System.out.println(0);
                continue;
            }
            if(input ==1 ){
                System.out.println(1);
                continue;
            }

            while(input > 1){
               int result = input / 2;
               int model = input % 2;
               if(model == 1){
                   count ++;
               }
               input = result;
            }
            System.out.println(count+1);
        }
    }
}
