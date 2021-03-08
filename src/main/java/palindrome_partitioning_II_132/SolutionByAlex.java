package palindrome_partitioning_II_132;

import java.util.*;

public class SolutionByAlex {

    public static int minCut(String s) {
        int n = s.length();
        //记忆dp优化判断是否为回文字符串
        boolean [][] g = new boolean[n][n];
        //初始化
        for(int i=0;i<n;i++){
            Arrays.fill(g[i],true);
        }
        for(int i=n-1;i>=0;i--){
            for(int j=i+1;j<n;j++){
                g[i][j] = s.charAt(i) == s.charAt(j) && g[i+1][j-1];
            }
        }
        int[] f = new int[n];
        Arrays.fill(f,Integer.MAX_VALUE);

        for(int i=0;i<n;i++){
            if(g[0][i]){
                f[i] = 0;
            }else {
                for(int j=0;j<i;j++){
                    if(g[j+1][i]){
                        f[i] = Math.min(f[i],f[j]+1);
                    }
                }
            }
        }
        return f[n-1];
    }




    public static void main(String[] args) {
        String input = "ababababababababababababcbabababababababababababa";
        System.out.println(input.length());
        System.out.println(minCut(input));
    }

}
