package flipping_an_image_832;


import java.util.Arrays;

public class SolutionByAlex {

    public static int[][] flipAndInvertImage(int[][] A) {
        int m = A.length;
        for(int i=0;i<m;i++){
            int[] temp = A[i];
            revert(temp,0,temp.length-1);
            overturn(temp);
        }
        return A;
    }

    public static void revert(int[] A,int left,int right){
        while(left < right){
            int temp = A[left];
            A[left] = A[right];
            A[right] = temp;
            left ++;
            right --;

        }
    }

    public static void overturn(int[] A){
        for(int i=0;i<A.length;i++){
            A[i] = A[i] == 0 ? 1 : 0;
        }
    }

    public static void main(String[] args) {
//        int[] A = {1,2,3,4,5,6,7,8};
//
//
//        int mid = A.length /2;
//        System.out.println(Arrays.toString(A));
//
//        revert(A,0,A.length-1);
//
//        revert(A,0,mid);
//
//        revert(A,mid+1,A.length-1);
//
//
//        int[] B = {1,0,1,0,1};
//        overturn(B);
//        System.out.println(Arrays.toString(B));
        int[][] A = {{1,1,0},{1,0,1},{0,0,0}};

        flipAndInvertImage(A);
        System.out.println("=============");
        for(int[] a1:A){
            System.out.println(Arrays.toString(a1));
        }

    }
}
