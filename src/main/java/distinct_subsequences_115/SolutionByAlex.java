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
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(j == 0){
                    dp[i][j] = 1;
                }else if(i == 0){
                    dp[i][j] = 0;
                }else {
                    if(s.charAt(i) == t.charAt(j)){
                        dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                    }else {
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
        }
        return dp[m-1][n-1];
    }

}


