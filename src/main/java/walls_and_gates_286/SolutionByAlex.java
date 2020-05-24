package walls_and_gates_286;

public class SolutionByAlex {
    public void wallsAndGates(int[][] rooms) {
        for(int row =0;row<rooms.length;row++){
            for(int col =0;col<rooms[0].length;col++){
                //计算每个门开始到每个点的距离
                if(rooms[row][col] == 0){
                    searchPath(rooms,row,col,0);
                }
            }
        }
    }
    public void searchPath(int[][] rooms,int row,int col,int path){
        if(row <0 || col <0 || row >= rooms.length || col >= rooms[0].length || rooms[row][col] < path){
            return;
        }
        rooms[row][col] = path;
        searchPath(rooms,row+1,col,path+1);
        searchPath(rooms,row-1,col,path+1);
        searchPath(rooms,row,col+1,path+1);
        searchPath(rooms,row,col-1,path+1);

    }

}
