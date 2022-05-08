package generate_parentheses_22;


import java.util.LinkedList;
import java.util.List;

public class SolutionByAlex {
    List<String> res = new LinkedList<>();
    public List<String> generateParenthesis(int n) {
        if(n == 0){
            return res;
        }
        StringBuilder track = new StringBuilder();
        backtrack(n,n,track);
        return res;
    }
    public void backtrack(int left,int right,StringBuilder track){
        // 先放左后放右
        if(right < left){
            return;
        }
        if(left < 0 || right < 0){
            return;
        }
        if(left == 0 && right ==0){
            res.add(track.toString());
            return;
        }
        track.append("(");
        backtrack(left-1,right,track);
        track.deleteCharAt(track.length()-1);

        track.append(")");
        backtrack(left,right-1,track);
        track.deleteCharAt(track.length()-1);
    }
}
