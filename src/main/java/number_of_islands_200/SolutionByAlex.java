package number_of_islands_200;

public class SolutionByAlex {

    public int numIslands(char[][] grid) {
        if(grid == null || grid.length ==0 || grid[0].length ==0){
            return 0;
        }
        int count =0;
        for(int i=0;i< grid.length;i++){
            for(int j=0;j< grid[0].length;j++){
                if(grid[i][j] =='1'){
                    count++;
                    dfs(grid,i,j);
                }

            }
        }
        return count;
    }

    public void dfs(char[][]grid,int row,int col){
        if(row<0 || col<0 ||row >= grid.length || col >= grid[0].length || grid[row][col] != '1'){
            return;
        }
        grid[row][col] = '2';
        //上下左右都要考虑，虽然是从上往下从左往右遍历的，但是会有s型岛屿
        dfs(grid,row+1,col);
        dfs(grid,row-1,col);
        dfs(grid,row,col+1);
        dfs(grid,row,col-1);
    }
}
