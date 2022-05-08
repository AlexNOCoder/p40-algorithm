package n_queens_51;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SolutionByAlex {
    List<List<String>> res = new LinkedList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(char[] c:board){
           Arrays.fill(c,'.');
        }
        backTrack(board,0);
        return res;
    }
    public void backTrack(char[][] board,int row){
        if(row == board.length){
            res.add(charToList(board));
            return;
        }
        int n = board[row].length;
        for(int col=0;col<n;col++){
            if(!isValid(board,row,col)){
                continue;
            }
            board[row][col] = 'Q';
            backTrack(board,row+1);
            board[row][col] = '.';
        }
    }

    public boolean isValid(char[][] board,int row,int col) {
        int n = board.length;
        // 检查列是否存在皇后冲突
        for(int i=0;i<n;i++){
            if(board[i][col] == 'Q'){
                return false;
            }
        }
        // 检查右上方是否存在皇后冲突
        for(int i = row -1,j=col+1;i >=0 && j<n;i--,j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        // 检查左上方是否存在皇后冲突
        for(int i = row -1,j=col-1;i >=0 && j>=0;i--,j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }

    public List charToList(char[][] board){
        List<String> list = new ArrayList<>();
        for(char[] c:board){
            list.add(String.copyValueOf(c));
        }
        return list;
    }


}
