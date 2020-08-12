package huawei_exercise_total_108;

import java.util.Scanner;

public class HJ13 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String input = sc.nextLine();
            String[] arr = input.split(" ");
            for(int i=arr.length-1;i>=0;i--){
                System.out.print(arr[i]);
                if(i !=0){
                    System.out.print(" ");
                }
            }


        }
    }
}
