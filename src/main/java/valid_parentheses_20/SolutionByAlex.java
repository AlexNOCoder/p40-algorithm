package valid_parentheses_20;

import java.util.Stack;

public class SolutionByAlex {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack();
        for(int i=0;i<chars.length;i++){
            if(stack.isEmpty()){
                stack.push(chars[i]);
            }else{
                Character temp = stack.peek();
                if(chars[i] == '('){
                    stack.push(chars[i]);
                }else if(chars[i] == ')'){
                    if(temp.equals('(')){
                        stack.pop();
                    }else{
                        stack.push(chars[i]);
                    }
                }else if(chars[i] == '{'){
                    stack.push(chars[i]);
                }else if(chars[i] == '}'){
                    if(temp.equals('{')){
                        stack.pop();
                    }else{
                        stack.push(chars[i]);
                    }
                }else if(chars[i] == '['){
                    stack.push(chars[i]);
                }else if(chars[i] == ']'){
                    if(temp.equals('[')){
                        stack.pop();
                    }else{
                        stack.push(chars[i]);
                    }
                }
            }
        }
        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }

    }


    //解法2，思路相同，代码看起来漂亮点
    public static boolean isValid2(String input){
        if(input.length() == 0){
            return true;
        }
        char[] inputChars = input.toCharArray();
        Stack<Character> stack  = new Stack<>();
        stack.push(inputChars[0]);
        int index=1;
        while(!stack.isEmpty() && index < inputChars.length){
            Character stackTop  = stack.peek();
            if(isMatch(stackTop,inputChars[index])){
                stack.pop();
                index++;
                if(stack.isEmpty() && index < inputChars.length){
                    //注意此处的细节，当栈空时，应当加入一个元素，让循环不结束，这个时候还得注意是否到了inputChars的尾部
                    stack.push(inputChars[index]);
                    index++;
                }
            }else {
                stack.push(inputChars[index]);
                index++;
            }
        }
        if(stack.isEmpty()){
            return true;
        }else {
            return false;
        }
    }

    public static boolean isMatch(char c1,char c2){
        if(c1 == '(' && c2 == ')'){
            return true;
        }else  if(c1 == '{' && c2 == '}'){
            return true;
        }else if(c1 =='['&& c2==']' ){
            return true;
        }else {
            return false;
        }

    }

}
