package kth_smallest_element_in_a_sorted_matrix_378;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SolutionByAlex {
    public static void main(String[] args) {
        int[][] matrix = {{1,2},{1,2}};
    }
    public int kthSmallest(int[][] matrix, int k) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                list.add(matrix[i][j]);
            }
        }
        return 0;
    }
}
