package longest_substring_without_repeating_characters_3;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolutionByAlex {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("dvdf"));
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();
        int result =0,i=0,j=0;
        List<Character> list =new ArrayList<>();
        for(;j<chars.length;){
            if(set.contains(chars[j])){
                int size = list.size();
                list.clear();
                set.clear();
                if(size > result){
                    result = size;
                }
                i++;
                j=i;
            }else {
                set.add(chars[j]);
                list.add(chars[j]);
                j++;
            }
        }
        if(i!=j){
            int lastSize = j-i;
            if(lastSize > result){
                result = lastSize;
            }
        }
        return result;
    }
}
