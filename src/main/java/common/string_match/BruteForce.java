package common.string_match;

/**
 * @author luoyuntian
 * @program: p40-algorithm
 * @description: 暴力匹配
 * @date 2022-03-02 21:08:23
 */
public class BruteForce {

    public static boolean isMatch(String main,String sub){
        for(int i=0;i<=(main.length() - sub.length());i++){
            if(main.substring(i,i+sub.length()).equals(sub)){
                return true;
            }
        }
        return false;
    }

}
