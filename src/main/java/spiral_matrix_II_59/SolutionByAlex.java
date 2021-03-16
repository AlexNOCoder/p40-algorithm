package spiral_matrix_II_59;

public class SolutionByAlex {
    public static void main(String[] args) {
    }

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int maxNum = n * n;
        int curNum = 1;
        int row =0,column= 0;
        //右下左上
        int [][] diretions= {{0,1},{1,0},{0,-1},{-1,0}};
        int directionIndex = 0;

        while(curNum <= maxNum){
            matrix[row][column] = curNum;
            curNum++;
            //判断是否转向
            int nexRow = row + diretions[directionIndex][0],nexColumn = column + diretions[directionIndex][1];
            if(nexRow < 0 || nexRow >=n || nexColumn < 0 || nexColumn >=0 || matrix[nexRow][nexColumn] !=0){
                directionIndex = (directionIndex +1) % 4;
            }
            //下一个坐标位置
            row = row + diretions[directionIndex][0];
            column = column + diretions[directionIndex][1];
        }

        return matrix;
    }
}
