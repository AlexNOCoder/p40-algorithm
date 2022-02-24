package longest_substring_without_repeating_characters_3;


import org.springframework.util.StringUtils;

import java.util.*;

public class SolutionByAlex {
    public static void main(String[] args) {
//        System.out.println(lengthOfLongestSubstring3("dvdf"));
//        System.out.println(lengthOfLongestSubstring3("pwwkew"));
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


    // clear
    int legnthOfLongestSubString2(String s){
        // 定义一个哈希集合set,初始化结果max为0
        Set<Character> set = new HashSet<>();
        int max = 0;
        // 利用快慢指针i和j扫描一遍字符串
        for(int i=0,j=0;j<s.length();j++){
            // 如果快指针指向的字符串已经出现在哈希集合中
            // 不断尝试将慢指针指向字符从哈希集合中删除
            while(set.contains(s.charAt(j))){
                set.remove(s.charAt(i));
                i++;
            }
            // 当快指针的字符终于能加入到哈希集合，更新结果max
            set.add(s.charAt(j));
            max = Math.max(max,set.size());
        }
        // 遍历完毕后，返回结果max
        return max;
    }

    // faster
    int legnthOfLongestSubString3(String s){
        // 定义一个哈希集合set记录上一次字符出现的位置
        Map<Character,Integer> map = new HashMap<>();
        // 初始化结果max为0
        int max = 0;
        // 利用快慢指针i和j扫描一遍字符串
        for(int i=0,j=0;j<s.length();j++){
            // 如果发现快指针对应的字符已经出现过，慢指针就进行跳跃
           if(map.containsKey(s.charAt(j))) {
                i = Math.max(i,map.get(s.charAt(j))+1);
           }
           // 把快指针所对应的字符添加到哈希表中
           map.put(s.charAt(j),j);
           // 更新max
           max = Math.max(max,j-i+1);
        }
        // 返回max
        return max;
    }
}
