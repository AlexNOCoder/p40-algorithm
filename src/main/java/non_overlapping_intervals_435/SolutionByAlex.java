package non_overlapping_intervals_435;


import java.util.Arrays;

public class SolutionByAlex {


    // 暴力法 ，时间超了
//    public int eraseOverlapIntervals(int[][] intervals) {
//        // 先将区间按照起始时间的先后顺序然后调用递归函数
//        Arrays.sort(intervals,(i1, i2)-> Integer.compare(i1[0],i2[0]));
//        return eraseOverlapIntervals(-1,0,intervals);
//    }
//
//
//    int eraseOverlapIntervals(int prev,int curr,int[][] intervals){
//        // 先检测所有区间是否已经处理完
//        // 是的话，表明不需要删除操作，直接返回
//        if(curr == intervals.length){
//            return 0;
//        }
//        // 定义taken和nottaken
//        // 如果保留当前区间的话，最少需要删除多少其他区间
//        // 如果删除当前区间的话，最少需要删除多少区间
//        int taken = Integer.MAX_VALUE;
//        int nottaken = 0;
//        // 只有当prev curr 没有发生重叠的时候，才可以选择保留当前的区间curr
//        if(prev == -1 || intervals[prev][1] <= intervals[curr][0]){
//
//            taken = eraseOverlapIntervals(curr,curr+1,intervals);
//        }
//        // 其他情况，可以考虑删掉curr区间，看看删除了它之后会不会产生最好的结果
//        nottaken = eraseOverlapIntervals(prev,curr+1,intervals)+1;
//        // 最后返回两种情况下的最小值，判断是否删除当前区间
//        return Math.min(taken,nottaken);
//    }

    // 按照起始时间贪心
//    public int eraseOverlapIntervals(int[][] intervals) {
//        if(intervals.length == 0){
//            return 0;
//        }
//        // 将所有的区间按照起始时间的先后顺序排序
//        Arrays.sort(intervals,(i1, i2)-> Integer.compare(i1[0],i2[0]));
//        // 定义end变量记录当前的最小结束时间点
//        int end = intervals[0][1];
//        // 定义count变量记录到目前为止删除了多少区间
//        int count = 0;
//        // 从第二个区间开始
//        for(int i=1;i<intervals.length;i++){
//            //  判断当前区间和前一个区间的结束时间
//            // 即当前区间的起始时间小于上一个区间的结束时间
//            // 则end记录两个结束时间的最小值
//            // 意味着把结束时间晚的区间删除，计数加1
//            if(intervals[i][0] < end){
//              end = Math.min(end,intervals[i][1]);
//              count++;
//            }else {
//                // 如果没有发生重叠，根据贪心算法，更新end为当前区间的结束时间
//                end = intervals[i][1];
//            }
//        }
//        return count;
//    }

    // 按照结束时间排序
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0){
            return 0;
        }
        // 将所有的区间按照结束时间的先后顺序排序
        Arrays.sort(intervals,(i1, i2)-> Integer.compare(i1[1],i2[1]));
        // 定义end变量记录当前的结束时间
        int end = intervals[0][1];
        // 定义count变量记录有多少个没有重叠的区间
        int count = 1;
        // 从第二个区间开始遍历剩下的区间
        for(int i=1;i<intervals.length;i++){
            // 如果发现当前区间与前一个区间结束时间没有重叠
            // 则计数加一，同时更新一下新的结束时间
            if(intervals[i][0] >= end){
                end = intervals[i][1];
                count++;
            }
        }
        // 最后用总区间的个数减去没有重叠的区间个数，得到最少要删除的区间个数
        return intervals.length - count;
    }
}
