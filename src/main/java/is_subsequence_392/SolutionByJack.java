package is_subsequence_392;

/**
 * @program: p40-algorithm
 * @description: 判断子序列
 * @author: lijie
 * @create: 2020-07-06 15:05
 */
public class SolutionByJack {
    public boolean isSubsequence(String s, String t){
        int i = 0;
        for (char ch: s.toCharArray()){
            while(i < t.length() && t.charAt(i) != ch) i++;
            i++;
        }
        return i <= t.length() ? true : false;
    }
}




//上面的程序，，
//动态规划套路详解
//动态规划第一个性质：重叠子问题。
/*
明确了问题，其实已经把问题解决了一般。既然耗时的原因是重复计算，我们可以造一个备忘录，每次算出
某个子问题的答案后别急着返回，先记到备忘录里再返回；每次遇到一个子问题先到备忘录里查一查，如果
发现之前已经解决过这个问题了，直接把答案拿出来用，不用再耗时去计算。
一般使用一个数组充当这个【备忘录】，也可以使用哈希表。
 */
