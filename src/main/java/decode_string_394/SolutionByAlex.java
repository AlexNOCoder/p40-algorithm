package decode_string_394;

import java.util.Stack;

public class SolutionByAlex {

    public static void main(String[] args) {
        String s = "100[leetcode]";
        System.out.println(decodeString(s));
    }

    public static String decodeString(String s) {
        Stack<String> stack =  new Stack();
        StringBuffer result = new StringBuffer();
        for(int i=0;i<s.length();i++){
            stack.push(String.valueOf(s.charAt(i)));
            if(stack.peek().equals("]")){
                if(!stack.isEmpty()){
                    stack.pop();
                    StringBuffer sb = new StringBuffer();
                    while(!stack.isEmpty() && !stack.peek().equals("[")){
                        sb.append(stack.pop());
                    }
                    stack.pop();
                    String num ="";
                    //数字不止一位
                    while(!stack.isEmpty() && stack.peek().toCharArray()[0] >='0' && stack.peek().toCharArray()[0] <= '9'){
                        num = stack.pop() + num;
                    }
                    int number = Integer.valueOf(num);
                    String temp = sb.toString();
                    for(int j=1;j<number;j++){
                        sb.append(temp);
                    }
                    stack.push(sb.toString());
                }
            }
        }
        while(!stack.isEmpty()){
            result.append(stack.pop());
        }

        return result.reverse().toString();
    }

}


