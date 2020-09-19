package word_search_79;

public class SolutionByAlex {
    //若匹配成功则返回true，匹配失败则继续遍历二维数组
    //若遍历结束都没有找到可以匹配的字符串，则返回false
    public static boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        int[][] visited = new int[board.length][board[0].length];
        //按行从左到右遍历二维数组
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                System.out.println("visited: "+board[i][j]);
               //判断该坐标是否能够匹配字符串
                if(isMatch(board,i,j,chars,0,visited)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean isMatch(char[][] board,int i,int j,char[] chars,int k,int[][] visited){
        if(board[i][j] != chars[k]){
            //如果首字母不匹配直接返回false
            return false;
        }else if(k == chars.length-1){
            //匹配到字符串尾部
            return true;
        }
        visited[i][j] = 1;
        boolean result  = false;
        int[][] directions = {{-1,0},{0,-1},{0,1},{1,0}};
        for(int[] direction:directions){
            int newi = i + direction[0];
            int newj = j + direction[1];
            //判断新的点是否已经访问过
            if(newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length){
                //判断新的坐标点是否越界
                if(visited[newi][newj] != 1){
                    //递归
                    System.out.println(board[i][j]+" : "+board[newi][newj]);
                    boolean flag = isMatch(board,newi,newj,chars,k+1,visited);
                    if(flag){
                        //若匹配成功则结果返回true，并结束循环
                        result = true;
                        break;
                    }
                }
            }
        }
        //将本次的访问记录擦除
        visited[i][j] = 0;
        return result;
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCB";
        System.out.println(exist(board,word));
    }
}
