package unique_binary_search_trees_96;

public class SolutionByAlex {
    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }

    public static int numTrees(int n) {
        //对于一个长度为n的树，可以用第i个树为分割，分割为区域[0..i]和[i+1..n]两段
        //对于这两个区域都是完整的树结构，可以有不同的树状结构
        //将g(n)表示为n个节点的树有多少种结构，f(i,n)表示为n个节点的树，通过第i个节点进行分割
        //则f(i,n) = g(i-1)*g(n-i)
        //g(n) = f(1)+f(2)+....+f(n)
        int[] dp= new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            for(int j=1;j<=i;j++){
               dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }
}
