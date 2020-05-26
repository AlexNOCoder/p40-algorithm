package evaluate_reverse_polish_notation_150;

import java.util.Stack;

public class SolutionByAlex {

    public int evalRPN(String[] tokens) {
        if(tokens.length == 1){
            return Integer.valueOf(tokens[0]);
        }
        Stack<String> stack = new Stack<>();
        int result = 0;
        for(int i = 0;i < tokens.length;i++){
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/") ){
                String num1 = stack.pop();
                String num2 = stack.pop();
                result = opeerationResult(num1,num2,tokens[i]);
                stack.push(result+"");
            }else {
                stack.push(tokens[i]);
            }
        }
        return result;
    }

    public int opeerationResult(String num1,String num2,String operation){
        if(operation.equals("+")){
            return Integer.valueOf(num2) + Integer.valueOf(num1);
        }else if(operation.equals("-")){
            return Integer.valueOf(num2) - Integer.valueOf(num1);
        }else if(operation.equals("*")){
            return Integer.valueOf(num2) * Integer.valueOf(num1);
        }else {
            return Integer.valueOf(num2) / Integer.valueOf(num1);
        }
    }

}


