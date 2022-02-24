package regular_expression_matching_10;

public class SolutionByAlex {
    // 递归解法
    public boolean isMatch1(String s, String p) {
        // 只要s和p有一个为null，则不匹配
        if(s == null || p == null){
            return false;
        }
        return isMatch1(s,0,p,0);
    }
    // 从前往后递归
    public boolean isMatch1(String s,int i,String p,int j){
        int m = s.length();
        int n = p.length();
        // 看看pattern和字符串是否都扫描完成
        // 递归函数的结束时间：
        // 当j指针遍历完p字符串后，即可跳出递归
        // 而当i指针也刚好遍历完，说明s和p完全匹配
        if(j == n){
          return i == m;
        }
        // 如果j指针的下一个不是星号，则递归调用isMatch函数
        if(j == n-1 || p.charAt(j+1) != '*'){
            return (i<m) && (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j) && isMatch1(s,i+1,p,j+1));
        }
        // 如果j指向的字符下一个为星号，则不断地将它和星号作为一个整体
        // 分别表示空字符串，一个j指向的字符，两个字符，以此类推
        if(j < n -1 && p.charAt(j+1) == '*'){
            // 整个算法的核心
            // i指向的字符必须要能和j指向的字符匹配 其中j指向的可能是点匹配符
            // 如果无法匹配i++，表示星号组合去匹配更长的一段字符串
            while((i<m) && (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j))){
                // 如果其中一种情况出现s和p匹配，则返回true
                if(isMatch1(s,i,p,j+2)){
                    return true;
                }
                i++;
            }
            // 当i和j指向的字符不相同，或i已遍历完s字符串，同时j指向的字符后跟一个星号的情况，我们只能用星号组合去表示一个空字符串，然后递归下去
        }
        return isMatch1(s,i,p,j+1);
    }
    // 递归解法
    public boolean isMatch2(String s, String p) {
        // 只要s和p有一个为null，则不匹配
        if(s == null || p == null){
            return false;
        }
        return isMatch2(s,s.length(),p,p.length());
    }

    // 从后往前递归
    public boolean isMatch2(String s,int i,String p,int j){
        // 如果p字符串为空，s字符串也为空，表示匹配
        if(j == 0){
            return i == 0;
        }
        // 如果p字符串不为空，而s字符串为空
        // 类似当s为空字符串，p为a*
        // 只要p总是由星号组合构成，则一定满足匹配，否则不行
        if(i == 0){
            return j>1 && p.charAt(j-1) == '*' && isMatch2(s,i,p,j-2);
        }
        // 当p的当前字符不是星号时，判断当前两个字符是否相等，如果相等，递归地看前面的字符
        if(p.charAt(j-1) != '*'){
            return isMatch(s.charAt(i-1),p.charAt(j-1)) && isMatch2(s,i-1,p,j-1);
        }
        // 否则，当p的当前字符是星号时，进行两种尝试
        // 用星号组合表示空字符串，看看是否能匹配
        // 用星号组合表示一个字符，看看是否能匹配
        return isMatch2(s,i,p,j-2) || isMatch2(s,i-1,p,j) && isMatch(s.charAt(i-1),p.charAt(j-2));
    }
    boolean isMatch(char a,char b){
        return a==b || b=='.';
    }

    // 动态规划
    boolean isMatch(String s,String p){
        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m+1][n+1];
        // 初始化dp[0][0]等于true，表示当两个字符串长度都是0，也就是空字符串时，他们互相匹配
        dp[0][0] = true;
        // 核心
        // 初始化二维矩阵第一行的所有值
        // 当s为空字符串时，对p字符串的任意位置，要使得这个位置的子串能和空字符串匹配，要求，这个子串都是有一系列的星号组合构成
        for(int j=1;j<=n;j++){
            dp[0][j] = j>1 &&p.charAt(j-1) == '*' && dp[0][j-2];
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                // p的当前字符不是星号的时候，判断当前两个字符是否相等，如果相等，则看看dp[i-1][j-1]的值，应为它保存了前一个匹配的结果
                if(p.charAt(j-1) != '*'){
                   dp[i][j] = dp[i-1][j-1] && isMatch(s.charAt(i-1),p.charAt(j-1));
                }else {
                    // 当p的当前字符是星号时，进行两种尝试
                    // 当星号组合表示空字符串，看看是否能匹配dp[i][j-2]
                    // 当星号表示一个字符，看看是否能匹配，即dp[i-1][j]
                    dp[i][j] = dp[i][j-2] || dp[i-1][j] && isMatch(s.charAt(i-1),p.charAt(j-2));
                 }
            }
        }
        return dp[m][n];
    }
}
