package longest_common_prefix_14;


public class SolutionByAlex {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        longestCommonPrefix(strs);
    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        if(strs.length == 1){
            return strs[0];
        }
        String result =strs[0];
        for(int i=1;i<strs.length;i++){
            while(strs[i].indexOf(result) != 0){
                //从后往前减少长度，直至匹配到最长前缀
                result = result.substring(0,result.length()-1);
            }
        }
        return result;
    }
}
