package huawei_exercise_total_108;

import java.util.PriorityQueue;
import java.util.Scanner;

public class HJ14 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputNum = sc.nextInt();
        sc.nextLine();
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();
        for(int i=0;i<inputNum;i++){
            priorityQueue.offer(sc.nextLine());
        }
        while (!priorityQueue.isEmpty()){
            System.out.println(priorityQueue.poll());
        }
    }
}
