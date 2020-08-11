package huawei_exercise_total_108;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class HJ8 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        sc.nextLine();
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<size;i++){
            String input = sc.nextLine();
            String[] arr = input.split(" ");
            Integer key = Integer.valueOf(arr[0]);
            Integer value = Integer.valueOf(arr[1]);
            if(map.containsKey(key)){
                Integer old = map.get(key);
                map.put(key,old+value);
            }else {
                map.put(key,value);
            }
        }
        Set<Integer> keySet = map.keySet();

        int max = 0;
        for(Integer key:keySet){
            if(key > max){
                max = key;
            }
        }
        int[] result = new int[max+1];

        for(Integer key:keySet){
           result[key] = map.get(key);
        }
        for(int j=0;j <= max;j++){
            if(result[j] != 0){
                System.out.println(j+" "+result[j]);
            }
        }
    }
}
