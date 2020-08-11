package huawei_exercise_total_108;

import java.util.Scanner;

public class HJ1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String input = sc.nextLine();
            String[] arr = input.split(" ");
            System.out.println(arr[arr.length-1].length());
        }
    }
}
