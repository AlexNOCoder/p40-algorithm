package max_increase_to_keep_city_skyline_807;

public class SolutionByAlex {
    public static int maxIncreaseKeepingSkyline(int[][] grid) {
        // 填充到上下左右的最小值
        int row = grid.length;
        int col = grid[0].length;
        int[] max_row = new int[row];
        int[] max_col = new int[col];
        int res = 0;
        // 初始化max_row
        for(int i=0;i<row;i++){
            int row_max =0;
            for(int j=0;j<col;j++){
                row_max = Math.max(row_max,grid[i][j]);
            }
            max_row[i] = row_max;
        }

        for(int i=0;i<col;i++){
            int col_max =0;
            for(int j=0;j<row;j++){
                col_max = Math.max(col_max,grid[j][i]);
            }
            max_col[i] = col_max;
        }
        for(int i=0;i< row;i++){
            for(int j=0;j<col;j++){
                int cur_max = Math.min(max_row[i],max_col[j]);
                if(cur_max > grid[i][j]){
                    res = res - grid[i][j] +  cur_max;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {3,0,8,4},
                {2,4,5,7},
                {9,2,6,3},
                {0,3,1,0}};
        System.out.println(maxIncreaseKeepingSkyline(grid));;
    }
}

