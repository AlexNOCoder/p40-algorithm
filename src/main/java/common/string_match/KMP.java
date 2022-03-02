package common.string_match;

/**
 * @author luoyuntian
 * @program: p40-algorithm
 * @description: KMP算法
 * @date 2022-03-02 21:59:45
 */
public class KMP {
    public int kmpSeach(String haystack, String needle){
        int m = haystack.length();
        int n = needle.length();

        if(n == 0){
            return 0;
        }
        // 求出needle的LPS，即最长的公共前缀和后缀数组
        int[] lps = getLPS(needle);

        // 定义两个指针i和j，用i来扫描haystack，用j来扫描needle
        int i =0;
        int j =0;
        // 进入循环体，直到i扫描完整个haystack，一旦扫描完还没有发现needle，则跳出循环
        while(i < m){
            // 在循环体中，当发现i指针和j指针指向的字符相等时，两个指针一起向前走一步
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
                // 一旦发现j已经扫描完needle字符串，说明haystack中找到了needle，立即返回它在haystack中的起始位置
                if(j == n){
                    return i -n;
                }
            }else if(j > 0 ){
                // 在循环体中，当发现i指针与j指针指向的字符不相同时，必须进行跳跃操作 j = LPS[j -1],这里必须判断j是否大于0
                j = lps[j-1];
            }else {
                // j等于0的情况，表明此时needle的第一个字符已不同于haystack的字符 ，尝试对比haystack的下一个字符，故i++
                i++;
            }
        }
        // 若未能在haystack中找到needle，返回-1
        return -1;
    }


    int[] getLPS(String str){
        // 初始化一个LPS数组来存放最终的结果
        int[] lps = new int[str.length()];
        // 由于LPS的第一个值一定是0，即长度为1的字符串的最长公共前缀后缀的长度为0,直接从第二个位置开始遍历
        int i=1;
        // 初始化当前最长的LPS长度为0，用len记录
        int len = 0;
        // 用i指针遍历整个输入字符串
        while(i<str.length()){
            // 如果i指针能够延续前缀和后缀
            if(str.charAt(i) == str.charAt(len)){
                // 更新LPS值为len+1；
                lps[i++] = ++len;
            }else if(len >0){
                // 否则判断len是否大于0，然后尝试第二长的前缀和后缀，看看是否能继续延续
                len = lps[len -1];
            }else {
                // 尝试了所有的前缀和后缀都不行时，则当前的LPS为0，i++
                i++;
            }
        }
        // 最后返回LPS数组
        return lps;
    }
}
