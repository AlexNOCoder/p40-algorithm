package transpose_matrix_867;

import java.util.Arrays;

/*
    转置矩阵
 */
public class SolutionByAlex {
    public static int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] trans = new int[n][m];
        for(int i=0;i<n;i++){
            int [] temp = new int[m];
            for(int j=0;j<m;j++){
                temp[j] = matrix[j][i];
            }
            trans[i] = temp;
        }
        return trans;
    }

    public static void main(String[] args) {
        int[][] A = {{2,4,-1},{-10,5,11},{18,-7,6}};
        int[][] B = {{1,2,3},{4,5,6}};

        int[][] resultA = transpose(A);
        for(int[] temp:resultA){
            System.out.println(Arrays.toString(temp));
        }
        System.out.println("=============");
        int[][] resultB = transpose(B);
        for(int[] temp:resultB){
            System.out.println(Arrays.toString(temp));
        }
    }
}
