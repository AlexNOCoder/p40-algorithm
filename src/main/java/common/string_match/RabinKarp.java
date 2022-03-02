package common.string_match;

/**
 * @author luoyuntian
 * @program: p40-algorithm
 * @description: 带哈希的字符串匹配
 * @date 2022-03-02 21:10:47
 */
public class RabinKarp {
    public static boolean isMatch(String main,String sub){
        // 算出子串的hash值
        int hash_sub = strToHash(sub);
        for(int i=0;i <= (main.length() - sub.length());i++){
            // 主串截取后与子串的hash值比较
            if(hash_sub == strToHash(main.substring(i,i+sub.length()))){
                return true;
            }
        }
        return false;
    }


    public static int strToHash(String src){
        int hash = 0;
        for(int i=0;i<src.length();i++){
            hash *= 26;
            hash += src.charAt(i) - 97;
        }
        return hash;
    }

}
