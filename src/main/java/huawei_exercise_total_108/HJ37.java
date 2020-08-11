package huawei_exercise_total_108;

import java.util.Scanner;

public class HJ37 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            System.out.println(getNum(sc.nextInt()));
        }
    }

    public static int getNum(int month){
        if(month ==1 || month==2){
            return 1;
        }
        return getNum(month-1)+getNum(month-2);
    }
}
