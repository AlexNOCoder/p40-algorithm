package largest_perimeter_triangle_976;


import java.util.Arrays;

public class SolutionByAlex {
    public static int largestPerimeter(int[] A) {
        Arrays.sort(A);
        int size = A.length;
        if(size < 3 ){
            return 0;
        }
        //最大值肯定是三条边长度都是最大的，
        int max=0;
        for(int i=0;i+2<size;i++){
            if(A[i+2] - A[i+1] < A[i]){
                //有一组满足可以拼出三角形,查看是否更新max
                max = Math.max(max,A[i+2]+A[i+1]+A[i]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] test1 ={2,1,2};
        int[] test2 ={1,2,1};
        int[] test3 ={3,2,3,4};
        int[] test4 ={3,6,2,3};
        System.out.println(largestPerimeter(test1));
        System.out.println(largestPerimeter(test2));
        System.out.println(largestPerimeter(test3));
        System.out.println(largestPerimeter(test4));
    }

}
