package range_sum_query_2d_304;


/*
    给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2) 。
 */
public class SolutionByAlex {

    private int[][] matrix;
    public SolutionByAlex(int[][] matrix ){
        this.matrix = matrix;
    }

    public int sumRegion(int row1,int col1,int row2,int col2){
        int m = matrix.length;
        int n = matrix[0].length;
        int sum =0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i<row1 || j <col1 || i>row2 || j>col2){
                    continue;
                }
                System.out.println("i："+i+" j: "+j+" num: "+matrix[i][j]);
                sum += matrix[i][j];
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        int[][] m = {{3,0,1,4,2},{5, 6, 3, 2, 1},{1, 2, 0, 1, 5},{4, 1, 0, 1, 7},{1, 0, 3, 0, 5}};
        SolutionByAlex s =new SolutionByAlex(m);
        s.sumRegion(2,1,4,3);
        System.out.println("==============");
        s.sumRegion(1,1,2,2);
        System.out.println("===============");
        s.sumRegion(1,2,2,4);

    }



}
