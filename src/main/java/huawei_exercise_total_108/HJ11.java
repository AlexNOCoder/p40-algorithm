package huawei_exercise_total_108;


import java.util.Scanner;

public class HJ11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String input = sc.nextLine();
            char[] inputChars = input.toCharArray();
            for(int i=0,j=inputChars.length-1;i<j;i++,j--){
                char temp = inputChars[i];
                inputChars[i] = inputChars[j];
                inputChars[j] = temp;
            }
            String result  = String.valueOf(inputChars);
            System.out.println(result);
        }
    }
}
