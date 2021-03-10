package basic_calculator_224;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionByAlex {
//    代码里面:
//
//    res 表示左边表达式除去栈内保存元素的计算结果；
//    sign 表示运算符；
//    num 表示当前遇到的数字，会更新到 res 中；
//    用栈保存遇到左括号时前面计算好了的结果和运算符。
//    操作的步骤是：
//
//    如果当前是数字，那么更新计算当前数字；
//    如果当前是操作符+或者-，那么需要更新计算当前计算的结果 res，并把当前数字 num 设为 0，sign 设为正负，重新开始；
//    如果当前是 ( ，那么说明遇到了右边的表达式，而后面的小括号里的内容需要优先计算，所以要把 res，sign 进栈，更新 res 和 sign 为新的开始；
//            如果当前是 ) ，那么说明右边的表达式结束，即当前括号里的内容已经计算完毕，所以要把之前的结果出栈，然后计算整个式子的结果；
//    最后，当所有数字结束的时候，需要把最后的一个 num 也更新到 res 中。

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
                    }
                    nums.addLast(u);
                    i = j-1;
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

    //基础运算
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
