package remove_all_adjacent_duplicates_in_string_1047;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionByAlex {
    public static String removeDuplicates(String S) {
        //将字符入栈，对比栈顶与当前字符是否相同，相同就出栈，不同就入栈
        Deque<Character> stack = new ArrayDeque<>();
        for(int i=0;i<S.length();i++){
            if(stack.isEmpty() || S.charAt(i) != stack.peek()){
                stack.push(S.charAt(i));
            }else {
                stack.pop();
            }
        }
       char[] result = new char[stack.size()];
        for(int i=stack.size()-1; i>=0;i--){
           result[i] = stack.pop();
        }
        return new String(result);
    }



    public static void main(String[] args) {
        String input = "abbaca";
        System.out.println(removeDuplicates(input));
    }

}
