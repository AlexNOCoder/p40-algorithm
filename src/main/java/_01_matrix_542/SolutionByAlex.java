package _01_matrix_542;

import java.util.LinkedList;
import java.util.Queue;

public class SolutionByAlex {

    //BFS
    public static void main(String[] args) {
        int[][] test ={{0},{0},{1},{1},{1},{1},{1},{1}};
        updateMatrix(test);
    }


    public static int[][] updateMatrix(int[][] matrix) {
        int[][] result = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    result[i][j] = 0;
                }else {
                   result[i][j] = getPathToZero(matrix,i,j);
                }
            }
        }
        return result;
    }

    public static int getPathToZero(int[][] matrix,int i,int j){
        int step = -1;
        Queue<Point> queue =  new LinkedList<>();
        queue.offer(new Point(i,j));
        while(!queue.isEmpty()){
            step++;
            //遍历一层
            int size = queue.size();
            for(int k=0;k<size;k++){
                Point point = queue.poll();
                if(matrix[point.x][point.y] == 0){
                    return step;
                }
                //向上
                if(point.x -1 >= 0) queue.offer(new Point(point.x-1,point.y));
                //向下
                if(point.x+1  < matrix.length) queue.offer(new Point(point.x+1,point.y));
                //向左
                if(point.y-1 >= 0) queue.offer(new Point(point.x,point.y-1));
                //向右
                if(point.y+1 < matrix[0].length) queue.offer(new Point(point.x,point.y+1));
            }
        }
        return step;
    }



}

class Point{
    int x;
    int y;
    public Point(int x,int y){
        this.x = x;
        this.y = y;
    }
}