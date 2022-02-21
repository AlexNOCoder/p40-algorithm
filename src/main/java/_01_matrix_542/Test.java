package _01_matrix_542;

import java.util.*;
import java.util.regex.Pattern;

public class Test {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            int input = sc.nextInt();
//            if(input == 0){
//                return;
//            }
//            getDrinkNumber(input);
//        }
//    }
//
//    public static void getDrinkNumber(int n){
//        int count =0;
//        while(n > 2){
//            int k = n/3;
//            int m = n%3;
//            count += k;
//            n = k+m;
//        }
//        if(n == 2){
//            count++;
//        }
//        System.out.println(count);
//    }
//public static void main(String[] args) {
//    Scanner sc = new Scanner(System.in);
//
//    while(sc.hasNext()){
//        int arrNum = sc.nextInt();
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue(new Comparator<Integer>(){
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1-o2;
//            }
//        });
//        for(;arrNum >0;arrNum--){
//            int num = sc.nextInt();
//            priorityQueue.add(num);
//        }
//        int pre = priorityQueue.poll();
//        System.out.println(pre);
//        while(!priorityQueue.isEmpty()){
//            int cur = priorityQueue.poll();
//            if(pre != cur){
//                pre = cur;
//                System.out.println(cur);
//            }
//        }
//    }
//}

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            String input = sc.nextLine();
//            String subInpput  =  input.substring(2);
//            char[] inputChars = subInpput.toCharArray();
//            int indexWeight = 1;
//            int result = 0;
//            for(int i= inputChars.length-1; i >= 0;i--){
//                result += transformNumber(inputChars[i])*indexWeight;
//                indexWeight *= 16;
//            }
//            System.out.println(result);
//        }
//
//    }

    public static int transformNumber(char c){
        Pattern pattern = Pattern.compile("^\\d+$");
        if(pattern.matcher(""+c).matches()){
            return Integer.valueOf(""+c);
        }

        switch (c){
            case 'A':
                return 10;
            case 'B':
                return 11;
            case 'C':
                return 12;
            case 'D':
                return 13;
            case 'E':
                return 14;
            case 'F':
                return 15;
            default:
                return 0;
        }
    }

    static void insertionSort(int[] unsorted){
        for (int i = 1; i < unsorted.length; i++) {
            if (unsorted[i - 1] > unsorted[i]) {
                int temp = unsorted[i];
                int j;
                for (j = i - 1; j >= 0 && unsorted[j] > temp; j--) {
                    unsorted[j + 1] = unsorted[j];
                }
                unsorted[j + 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] test={1,3,2,4,8,0,7,5};
        insertionSort(test);
        for (int i:test){
            System.out.println(i);
        }
    }

}
