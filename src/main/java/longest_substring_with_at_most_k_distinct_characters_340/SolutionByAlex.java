package longest_substring_with_at_most_k_distinct_characters_340;


import java.util.HashMap;

public class SolutionByAlex {
        int lengthOfLongestSubstringKDistinct(String s,int k){
            // 统计出现的不同字符
            HashMap<Character,Integer> map = new HashMap<>();
            // 用max变量记录最长的子串，其中最多包括k个不同字符
            int max = 0;
            // 用快慢指针遍历字符
            for(int i=0,j=0;j<s.length();j++){
                char cj = s.charAt(j);
                // 将快指针指向的字符加入到map，统计字符出现的次数
                map.put(cj,map.getOrDefault(cj,0)+1);
                // 如果发现map的大小超过了k，则开始不断将慢指针指向的字符从map中清除掉
                while(map.size()>k){
                    char ci = s.charAt(i);
                    // 说去当前慢指针指向的字符，将它在map中的计数减一
                    map.put(ci,map.get(ci)-1);
                    // 一旦它的统计次数变为0，就可以把它从map中删除
                    if(map.get(ci)==0){
                        map.remove(ci);
                    }
                    // 慢指针继续往前走
                    i++;
                }
                // 当map的大小恢复正常，统计一下当前子串的长度
                max = Math.max(max,j-i+1);
            }
            // 最后返回最大的子串长度
            return max;
        }

    }
