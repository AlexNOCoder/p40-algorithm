package binary_watch_401;


import java.util.ArrayList;
import java.util.List;

public class SolutionByAlex {

//    result = []
//    def backtrack(路径, 选择列表):
//         if 满足结束条件:
//            result.add(路径)
//            return
//
//        for 选择 in 选择列表:
//              做选择
//              backtrack(路径, 选择列表)
//              撤销选择
    public List<String> readBinaryWatch(int num) {
        int[] hours = {1,2,4,8};
        int[] seconds = {1,2,4,8,16,32};
        List<String> result = new ArrayList<>();
        backTrack(num,hours,seconds,result);

        return null;
    }

    public void backTrack(int num,int[] hours,int[] seconds,List<String> track){


    }

}
