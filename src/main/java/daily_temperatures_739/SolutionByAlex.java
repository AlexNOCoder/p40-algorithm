package daily_temperatures_739;

import java.util.Stack;

public class SolutionByAlex {

    public static void main(String[] args) {
        int[] temp = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = dailyTemperatures(temp);
        for(int i:result){
            System.out.println(i);
        }
    }

    //比较index的差值就能得出间隔多少天
    public static int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<T.length;i++){
            while(!stack.isEmpty() && T[i] > T[stack.peek()]){
                int temp = stack.pop();
                result[temp] = i - temp;
            }
            stack.push(i);
        }

        return result;

    }

}


