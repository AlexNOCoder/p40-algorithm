package repeated_substring_pattern_459;
public class SolutionByAlex {
    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("abaababaab"));
    }
    public static boolean repeatedSubstringPattern(String s) {
        //不管奇数还是偶数个子串，double以后就都是偶数个，然后再查找就可以得到
        return (s + s).indexOf(s, 1) != s.length();
    }

}
