package unique_paths_II_63;

public class SolutionByAlex {

    public static void main(String[] args) {
        int[][] matrix = {{0,0,0},{0,1,0},{0,0,0}};

        System.out.println(uniquePathsWithObstacles(matrix));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0][0] ==1){
            return 0;
        }

        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        //创建dp数组
        int[][] dp = new int[row][col];
        dp[0][0]=1;
        //初始化
        for(int i=0;i<row && obstacleGrid[i][0] ==0;i++){
            dp[i][0] = 1;
        }

        for(int j=0;j<col && obstacleGrid[0][j] ==0;j++){
            dp[0][j] = 1;
        }
        //状态转移方程分成两种情况：
        //当目标点为障碍时，0
        //当目标点不为障碍时，dp[i-1][j] + dp[i][j-1]

        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                if(obstacleGrid[i][j] == 0){
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }

            }
        }

        return dp[row-1][col-1];
    }
}
