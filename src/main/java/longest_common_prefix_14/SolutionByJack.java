package longest_common_prefix_14;

/**
 * @program: p40-algorithm
 * @description: 最长公共前缀
 * @author: lijie
 * @create: 2020-07-01 16:38
 */
public class SolutionByJack {






    public String longestCommonPrefix(String[] strs){
        if (strs == null || strs.length == 0){
            return "";
        }
        String prefix = strs[0];
        int count = strs.length;
        for (int i = 1; i < count; i ++){
            prefix = longsetCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0){
                break;
            }
        }
        return prefix;
    }


    private String longsetCommonPrefix(String str1, String str2){
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while(index < length && str1.charAt(index) == str2.charAt(index)){
            index ++;
        }
        return str1.substring(0, index);
    }


}
