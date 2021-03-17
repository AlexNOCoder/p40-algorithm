package distinct_subsequences_115;

public class SolutionByAlex {
    public int numDistinct(String s, String t) {
        /*
          求s的子序列中t出现的个数
          即：s串在自身选字符匹配t串字符

          对于某一个位置：
          如果匹配上了： s[i] == t[j]，则继续考察s[i-1] 与 t[j-1]
          如果未匹配上： s[i] != t[j],继续考察s[i-1] 与 t[j]

          结束条件,当j已经到0，则数量1；当i已经到0，但j没有到0，则数量0

          dp[i][j]表示前i个字符串的s字符串，出现前j个字符串t的次数
         */
        int m = s.length();
        int n = t.length();
        if(m < n){
         return 0;
        }
        int[][] dp = new int[m+1][n+1];
        //将t字符串为0的情况都置为1
        for (int i = 0; i <= m; i++) {
            dp[i][n] = 1;
        }
        for (int i = m - 1; i >= 0; i--) {
            char sChar = s.charAt(i);
            for (int j = n - 1; j >= 0; j--) {
                char tChar = t.charAt(j);
                if (sChar == tChar) {
                    dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j];
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }
        return dp[0][0];
    }

}


