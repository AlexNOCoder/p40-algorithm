package valid_parentheses_20;

import java.util.HashMap;
import java.util.Stack;

/**
 * @program: p40-algorithm
 * @description: 有效的括号
 * @author: lijie
 * @create: 2020-07-02 09:43
 */
public class SolutionByJack {
    //Hash table takes care of the mappings
    private HashMap<Character, Character> mappings;

    //Initialize hash map with mappings. This simply makes the code easier to read.
    public SolutionByJack(){
        this.mappings = new HashMap<Character, Character>();
        this.mappings.put(')','(');
        this.mappings.put('}','{');
        this.mappings.put('[',']');
    }

    public boolean isVslid(String s){
        //Initialize a stack to be used in the algorithm
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i ++){
            char c = s.charAt(i);

            //If the current character is a closing bracket.
            if (this.mappings.containsKey(c)){
                //Get the top element of the stack. If the stack is empty, set a dummy value of '#'
                char topElement = stack.empty() ? '#' : stack.pop();

                //If the mapping for this bracket doesnt match the stack's top element, return false.
                if (topElement != this.mappings.get(c)){
                    return false;
                }
            }else{
                //If it was an opening bracket, push to the stack.
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
