package toeplitz_matrix_766;

/**
 *如果矩阵上每一条由左上到右下的对角线上的元素都相同，那么这个矩阵是托普利茨矩阵
 */
public class SolutionByAlex {
    public boolean isToeplitzMatrix(int[][] matrix) {
        //遍历第一行和第一列，在矩阵范围内判断是否满足
        //m行n列
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] != matrix[i - 1][j - 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
