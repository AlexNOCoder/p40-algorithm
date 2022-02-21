package merge_intervals_56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionByAlex {
 int [][] merge(int [][] intervals){
     // 将所有的区间按照起始时间的先后顺序排序
     Arrays.sort(intervals,(i1, i2) -> Integer.compare(i1[0],i2[0]));
     // 定义一个preivious变量，初始化为null
     int[] privious = null;
     // 定义一个result变量，用来保存最终的区间结果
     List<int[]> result = new ArrayList<>();
     // 从头遍历给定的所有区间
     for(int[] current:intervals){
         // 如果这是第一个区间，或者当前区间和前一个区间没有重叠，那么将当前区间加入到结果中
        if(privious == null || current[0] > privious[1]) {
            result.add(privious = current);
        }else {
            // 否则，两个区间发生了重叠，更新前一个区间的结束时间，最后返回结果
            privious[1] = Math.max(privious[1],current[1]);
        }

     }
     // 返回结果
     return result.toArray(new int[result.size()][]);
 }
}

