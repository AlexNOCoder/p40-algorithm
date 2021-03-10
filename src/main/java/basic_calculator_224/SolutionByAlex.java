package basic_calculator_224;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionByAlex {
    public static int calculate(String s) {
        /*
        创建一个栈，将字符依次压入栈中，如果遇到右括号，则弹出字符，直到弹出第一个左括号
        将这些弹出的数据计算出结果，再次压入栈中，直到字符都已入栈
        则将栈内元素弹出计算结果
        不能使用字符分割，可能一个数字占用了多个字符
         */
        int length = s.length();
        Deque<Character> stack = new ArrayDeque<>();
        Deque<Character> tempStack = new ArrayDeque<>();
        stack.push(s.charAt(0));
        for(int i=1;i<length;i++){
            char temp = s.charAt(i);
            if(temp == ')'){
                while(!stack.peek().equals('(')){
                    tempStack.push(stack.pop());
                }
                Character reuslt = getResult(tempStack);
                stack.push(reuslt);
                System.out.println("reuslt "+reuslt);
                tempStack.clear();
            }else {
                stack.push(temp);
            }
        }

        return Integer.valueOf(getResult(stack));
    }


    public static char getResult(Deque<Character> stack){
        int result =Integer.valueOf(stack.pop());
        while(!stack.isEmpty()){
            Character c = stack.pop();
            if(c.equals('+')){
                result += Integer.valueOf(stack.pop());
            }
            if(c.equals('-')){
                result -= Integer.valueOf(stack.pop());
            }
        }

        return (char)result;
    }


    public static void main(String[] args) {
        String input = "(1+2)-(2-3)";
        System.out.println(calculate(input));
    }

}
