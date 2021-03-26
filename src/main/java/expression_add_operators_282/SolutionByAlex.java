package expression_add_operators_282;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SolutionByAlex {
    private List<String> result = new LinkedList<>();
    //通过回溯算法找到所有的可能的结果
    public List<String> addOperators(String num, int target) {
        int length = num.length();

        if(length == 0){
            return result;
        }
        //通过stack保存回溯路径
        Deque<String> stack = new ArrayDeque<>();
        char[] chars = num.toCharArray();
        dfs(chars,0,length,stack,result,target,0,"");

        return result;
    }



    //通过深度优先遍历，将每种情况遍历出来

    public void dfs(char[] chars,int index,int length,Deque<String> stack,List<String> path,int target,int curVal,String operation){
        //todo 深度搜索到最后，并且结果等于target,则将结果加入队列
        if(index ==length){

        }
        //从index到len区间内判断
        for (int i = index;i < length;i++){

            //深度优先遍历递归实现，找出每一种可能并加入到res中
            stack.addLast(new String(chars,index,i+1-index));
            dfs(chars,i+1,length,stack,path,target,0,"+");
            dfs(chars,i+1,length,stack,path,target,0,"-");
            dfs(chars,i+1,length,stack,path,target,0,"*");
            stack.removeLast();
        }
    }

    public boolean isMatch(List<String> path,int target){
        //todo 判断该种可能的结果是否是target
        return false;
    }
}
//    vector<string> res;
//    string path;
//    vector<string> addOperators(string num, int target) {
//        if(num == ""){
//            return {};
//        }
//        dfs(0,0,1,num[0] - '0',1,num.size(),target,num);
//        return res;
//    }
//
//    void dfs(int idx,LL pre,LL left,LL operand,int sign,int n,int target,string& num){
//        //查看串尾是否运算符来判断当前数字是否操作数的首位
//        bool isBeg = path.empty() || path.back() < '0';
//
//        path += num[idx];
//        if(idx == n - 1){
//            if(pre + sign * left * operand == target){
//                res.emplace_back(path);
//            }
//        }else{
//            int next_num = num[idx + 1] - '0';
//            string old_path = path;
//            //追加数字时不能形成有前导0的情况
//            if(!(isBeg && num[idx] == '0')){
//                dfs(idx + 1,pre,left,operand * 10 + next_num,sign,n,target,num);
//                path = old_path;
//            }
//            path += '+';
//            dfs(idx + 1,pre + sign * left * operand,1,next_num,1,n,target,num);
//            path = old_path;
//
//            path += '-';
//            dfs(idx + 1,pre + sign * left * operand,1,next_num,-1,n,target,num);
//            path = old_path;
//
//            path += '*';
//            dfs(idx + 1,pre,left * operand,next_num,sign,n,target,num);
//        }
//    }
//