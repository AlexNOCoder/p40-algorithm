package valid_mountain_array_941;

public class SolutionByAlex {
    public static boolean validMountainArray(int[] A) {
        if(A.length < 3){
           return false ;
        }
        int i=0,j=A.length-1;

        for(;i< A.length-1;){
            if(A[i]<A[i+1]){
                i++;
            }else {
                break;
            }
        }
        for(;j > 1;){
            if(A[j] < A[j-1]){
                j--;
            }else {
                break;
            }
        }

        if(i == j && i !=0 && j != A.length-1){
            return true;
        }else {
            return false;
        }

    }

    public static void main(String[] args) {
        int[] test1 = {3,5,5};
        int[] test2 = {0,3,2,1};
        int[] test3 = {0,1,2,3,4,5,6,7,8,9};
        System.out.println(validMountainArray(test1));
        System.out.println(validMountainArray(test2));
        System.out.println(validMountainArray(test3));
    }
}
