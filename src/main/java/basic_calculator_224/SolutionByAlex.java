package basic_calculator_224;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionByAlex {
    public static int calculate(String s) {
        Deque<Integer> nums = new ArrayDeque<>();
        //处理第一个数为负数的情况
        nums.addLast(0);

        Deque<Character> ops = new ArrayDeque<>();

        int n = s.length();
        char[] cs = s.toCharArray();

        for(int i=0;i<n;i++){
            char c = cs[i];
            if(c == ' '){
                continue;
            }else if(c == '('){
                ops.addLast(c);
            }else if(c == ')'){
                //计算到最近一个右括号
                while(!ops.isEmpty()){
                    char op = ops.peekLast();
                    if(op != '('){
                        cal(nums,ops);
                    }else {
                        ops.pollLast();
                        break;
                    }
                }
            }else {
                if(isNum(c)){
                    int u =0;
                    int j =i;
                    //从i开始连续数字取出，加入nums
                    while(j < n && isNum(cs[j])){
                        u = u* 10 +(int)(cs[j++] -'0');
                        nums.addLast(u);
                        i = j-1;
                    }
                }else {
                    while(!ops.isEmpty() && ops.peekLast() != ')'){
                        cal(nums,ops);
                    }
                    ops.addLast(c);
                }
            }
        }
        while (!ops.isEmpty()){
            cal(nums,ops);
        }
        return nums.peekLast();
    }


    public static boolean isNum(char c){
        return Character.isDigit(c);
    }

    public static void cal(Deque<Integer> nums,Deque<Character> ops){
        if(nums.isEmpty() || nums.size() < 2){
            return;
        }
        if(ops.isEmpty()){
            return;
        }
        int b = nums.pollLast(),a=nums.pollLast();
        char op = ops.pollLast();
        nums.addLast(op == '+' ? a+b : a-b);
    }


    public static void main(String[] args) {
        String input = "(1+2)-(2-3)";
        System.out.println(calculate(input));
    }

}
