package flood_fill_733;


public class SolutionByAlex {

    public static void main(String[] args) {
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        floodFill(image,1,1,2);

    }


    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        fill(image,sr,sc,newColor,image[sr][sc]);
        print2DArray(image);
        return image;
    }

    public static void fill(int[][] image, int sr, int sc, int newColor,int oringalColor){

        if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] == newColor || image[sr][sc] != oringalColor){
            return;
        }
        System.out.println("image["+sr+"]"+"["+sc+"]: "+image[sr][sc]);
        print2DArray(image);
        image[sr][sc] = newColor;

        fill(image,sr+1,sc,newColor,oringalColor);
        fill(image,sr-1,sc,newColor,oringalColor);
        fill(image,sr,sc+1,newColor,oringalColor);
        fill(image,sr,sc-1,newColor,oringalColor);
    }

    public static void print2DArray(int[][] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print("{");
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]);
                System.out.print(",");
            }
            System.out.println("}");
        }
        System.out.println("====================");
    }
}
