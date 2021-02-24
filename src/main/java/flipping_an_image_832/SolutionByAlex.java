package flipping_an_image_832;


import java.util.Arrays;

public class SolutionByAlex {

    public static int[][] flipAndInvertImage(int[][] A) {
        int m = A.length;
        int n = A[0].length;



        return null;
    }

    public static int[] revert(int[] A,int left,int right){
        while(left < right){
            int temp = A[left];
            A[left] = A[right];
            A[right] = temp;
            left ++;
            right --;

        }
        System.out.println(Arrays.toString(A));
        return A;
    }

    public static int[] overturn(int[] A){
        for(int i=0;i<A.length;i++){
            A[i] = A[i] == 0 ? 1 : 0;
        }
        return A;
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,4,5,6,7,8};


        int mid = A.length /2;
        System.out.println(Arrays.toString(A));

        revert(A,0,A.length-1);

        revert(A,0,mid);

        revert(A,mid+1,A.length-1);


        int[] B = {1,0,1,0,1};
        overturn(B);
        System.out.println(Arrays.toString(B));
    }
}
