package paint_fence_276;

public class SolutionByAlex {
    public static void main(String[] args) {
        System.out.println(numWays(3,2));
    }

    public static int numWays(int n, int k) {
        //对于第n个栅栏会分为两种上色可能
        //1.第n个栅栏与第n-1栅栏颜色不同，则可以直接上色
        //2.第n个栅栏与第n-2栅栏颜色相同，则要判断第n个栅栏与n-2个栅栏颜色是否相同，如果不同，则可以直接上色
        if(k == 0 || n==0){
            return 0;
        }
        if(n == 1){
            return k;
        }
        int[] dp = new int[n+1];
        dp[1] = k;
        dp[2] = k*k;
        for(int i=3;i<=n;i++){
            dp[i]= (dp[i-1]*(k-1))+(dp[i-2]*(k-1));
        }
        return dp[n];

    }
}
