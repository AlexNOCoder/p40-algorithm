package reverse_words_in_a_string_III_557;

public class SolutionByAlex {
    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }

    public static String reverseWords(String s) {
        StringBuilder result  = new StringBuilder();
        String[] strArr = s.split(" ");
        for(String temp : strArr){
            char[] chars = temp.toCharArray();
            for(int i=chars.length-1;i>=0;i--){
                result.append(chars[i]);
            }
            result.append(" ");
        }
        return result.substring(0,result.length()-1);
    }
}
