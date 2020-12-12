package common.utils;
public class QuickMatrix {


    public static int[][] multiply(int [][]a,int[][]b){
        int[][]arr=new int[a.length][b[0].length];
        for(int i=0;i<a.length;i++){
            for(int j=0;j<b[0].length;j++){
                for(int k=0;k<a[0].length;k++){
                    arr[i][j]+=a[i][k]*b[k][j];
                }
            }
        }
        return arr;
    }
    public static int[][] quickMatrix(int[][]a,int n){
        int[][] res=new int[a.length][a[0].length];
        for(int i=0;i<res.length;i++){
            for(int j=0;j<res[0].length;j++){
                if(i==j)
                    res[i][j]=1;
                else
                    res[i][j]=0;
            }

        }
        while(n!=0){
            if((n&1)==1)
                res=multiply(res,a);
            n>>=1;
            a=multiply(a,a);
        }
        return res;
    }
    public static void main(String[] args) {
        int [][]arr={{1,1,1},{1,1,1},{1,1,1}};
        int[][]arr1=quickMatrix(arr,3);
        for(int i=0;i<arr1.length;i++){
            for(int j=0;j<arr1[0].length;j++){
                System.out.print(arr1[i][j]+"   ");
            }
            System.out.println();
        }
    }

}
