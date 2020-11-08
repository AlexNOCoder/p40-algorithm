package common.dp;
public class UniquePaths {
    //也可以通过排列组合C(m+n-2,m-1)，时间复杂度为O(n)，空间复杂度O(1)
    public static int uniquePaths(int m,int n){
        //开辟空间
        int [][]f = new int[m][n];
        //从左到右
        for(int i=0;i<m;i++){
            //从上到下
            for(int j=0;j<n;j++){
                //初始化+边界
                if(i == 0 || j == 0){
                    f[i][j] = 1;
                }else {
                    //状态转移
                    f[i][j] = f[i-1][j] + f[i][j-1];
                }
            }
        }

        return f[m-1][n-1];
    }
}
