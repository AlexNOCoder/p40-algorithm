package longest_substring_without_repeating_characters_3;


import org.springframework.util.StringUtils;

import java.util.*;

public class SolutionByAlex {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring3("dvdf"));
        System.out.println(lengthOfLongestSubstring3("pwwkew"));
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


    // fater
    public static int lengthOfLongestSubstring3(String s){
        // 处理s为
        if(s == null || s.length() == 0){
            return 0;
        }
        // key 为 char，value 为 index
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                // 如果已经存在，将left移动到上一个出现位置的下一个
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;
    }



}
