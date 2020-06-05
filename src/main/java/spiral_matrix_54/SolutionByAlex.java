package spiral_matrix_54;


import java.util.ArrayList;
import java.util.List;

public class SolutionByAlex {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> result  = spiralOrder(matrix);
        for(Integer i:result){
            System.out.println(i);
        }
    }



    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(matrix == null){
            return null;
        }
        if(matrix.length == 0){
            return result;
        }

        int matrix_row = matrix.length;
        int matrix_col = matrix[0].length;
        int up = 0,down = matrix_row -1,left = 0,right = matrix_col -1;

        while(true){

            //
            for(int i=left;i<=right;i++){
                result.add((matrix[up][i]));
            }
            up++;
            if(up > down){
                break;
            }

            //
            for(int i=up;i<=down;i++){
                result.add(matrix[i][right]);

            }
            right--;
            if(right < left){
                break;
            }

            //
            for(int i=right;i>=left;i--){
                result.add(matrix[down][i]);
            }
            down--;
            if(down < up){
                break;
            }

            //
            for(int i=down;i >=up;i--){
                result.add(matrix[i][left]);
            }
            left++;
            if(left > right){
                break;
            }
        }
        return result;
    }
}
