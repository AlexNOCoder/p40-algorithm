package kth_smallest_element_in_a_sorted_matrix_378;


import java.util.*;
//对于topk问题一般都使用堆实现，java中通过优先队列来实现堆
public class SolutionByAlex {
    public static void main(String[] args) {
        int[][] matrix = {{1,3,5},{6,7,12},{11,14,14}};
        System.out.println(kthSmallest(matrix,6));
    }
    public static int kthSmallest(int[][] matrix, int k) {
        if(matrix == null){
            return 0;
        }
        if(matrix.length == 1 && matrix[0].length ==1){
            return matrix[0][0];
        }
        //使用优先队列试下小根堆
        PriorityQueue<int []> priorityQueue = new PriorityQueue<int []>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // a - b 小根堆
                // b - a 大根堆
                return o1[0]-o2[0];
            }
        });
        //防止重复加入set
        Set<Integer> vistiedSet =  new HashSet<>();
        //将矩阵左上角最小值加入优先队列
        priorityQueue.offer(new int[]{matrix[0][0],0,0});
        for(int i=0;i<k-1;i++){
            int[] temp = priorityQueue.poll();
            int col = temp[1];
            int row = temp[2];
            if(col+1 < matrix.length && !vistiedSet.contains((col+1) * matrix.length + row)){
                vistiedSet.add((col+1) * matrix.length + row);
                priorityQueue.offer(new int[]{matrix[col+1][row],col+1,row});
            }
            if(row+1 < matrix[0].length && !vistiedSet.contains(col * matrix.length + row+1)){
                vistiedSet.add(col * matrix.length + row+1);
                priorityQueue.offer(new int[]{matrix[col][row+1],col,row+1});
            }
        }
        return priorityQueue.poll()[0];
    }
}
