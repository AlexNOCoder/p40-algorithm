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

}
