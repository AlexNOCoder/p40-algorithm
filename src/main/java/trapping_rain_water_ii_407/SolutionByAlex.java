package trapping_rain_water_ii_407;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SolutionByAlex {
    public int trapRainWater(int[][] heightMap) {
        if(heightMap == null || heightMap.length == 0 || heightMap[0].length ==0){
           return 0;
        }
        // 用变量m和n分别表示输入矩阵的行数和列数
        int m = heightMap.length;
        int n = heightMap[0].length;
        // 定义一个优先队列或者最小堆
        // 按照每个方块接了雨水后的高度排列
        PriorityQueue<Cell> queue = new PriorityQueue<Cell>(new Comparator<Cell>(){
            public int compare(Cell c1, Cell c2) {
                return c1.height - c2.height;
            }
        });
        boolean[][] visited = new boolean[m][n];
        // 初始化优先队列时，把矩形的外围四个边上的方块都加入优先队列中
        for(int i=0;i<m;i++){
            visited[i][0] =true;
            visited[i][n-1] = true;
            queue.offer(new Cell(i,0,heightMap[i][0]));
            queue.offer(new Cell(i,n-1,heightMap[i][n-1]));
        }
        for(int j=0;j<n;j++){
           visited[0][j] = true;
           visited[m-1][j] = true;
           queue.offer(new Cell(0,j,heightMap[0][j]));
           queue.offer(new Cell(m-1,j,heightMap[m-1][j]));
        }

        int[][] dirs ={{-1,0},{1,0},{0,-1},{0,1}};
        int total = 0;
        // 进入while循环，开始进行BFS
        while(!queue.isEmpty()){
            // 每次从优先队列中取出最矮的方块
            Cell cell = queue.poll();
            for(int[] dir:dirs){
               int row = cell.row + dir[0];
               int col = cell.col + dir[1];
               // 该方向上的相邻方块能接多少水，取决于它是否大于当前方块
                if(row >= 0 && row < m && col >=0 && col < n && !visited[row][col]){
                    visited[row][col] = true;
                    total += Math.max(0,cell.height-heightMap[row][col]);
                    // 将新的方块加入到优先队列中
                    queue.offer(new Cell(row,col,Math.max(heightMap[row][col],cell.height)));
                }
            }
        }
        // 最后返回承接的雨水总量
        return total;
    }
}
// 为了配合优先队列使用，定义cell类，来保存每个方块的坐标以及接了雨水后的高度
class Cell{
    int row;
    int col;
    int height;
    public Cell(int row,int col,int height){
        this.row = row;
        this.col = col;
        this.height = height;
    }
}

