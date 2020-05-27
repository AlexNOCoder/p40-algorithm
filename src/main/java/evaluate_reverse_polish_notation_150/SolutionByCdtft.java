package evaluate_reverse_polish_notation_150;

import java.util.Stack;

/**
 * @author : wangcheng
 * @date : 2020年05月27日 13:51
 */
public class SolutionByCdtft {
    public int evalRPN(String[] tokens) {
        if (tokens.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        for (String item : tokens) {
            if (isOp(item)) {
                Integer b = stack.pop();
                Integer a = stack.pop();
                Integer result = op(a, b, item);
                stack.push(result);
            } else {
                stack.push(Integer.valueOf(item));
            }
        }
        return stack.pop();
    }

    private boolean isOp(String op) {
        return op.equals("+") || op.equals("-") || op.equals("/") || op.equals("*");
    }

    private Integer op(Integer a, Integer b, String op) {
        int result = 0;
        switch (op) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "/":
                result = a / b;
                break;
            case "*":
                result = a * b;
                break;
            default:
                break;
        }
        return result;
    }

    public static void main(String[] args) {
        SolutionByCdtft solutionByCdtft = new SolutionByCdtft();
        String[] test = new String[]{"4", "13", "5", "/", "+"};
        solutionByCdtft.evalRPN(test);
    }
}
