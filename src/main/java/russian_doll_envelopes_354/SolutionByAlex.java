package russian_doll_envelopes_354;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionByAlex {

    /**
       * @author luoyuntian
       * @date 2020-10-03 16:49
       * @description 先排序，再根据宽和高分别进行LIS
       * @return
       */
    public static int maxEnvelopes(int[][] envelopes) {
        //dp[i]表示在[0..i]信封中最多的嵌套个数
        //situation[i][2]表示第i个位置中，最多嵌套个数的时候，位于首位和尾部的宽高，
        //situation应该保存所有的可能，然后遍历其所有可能才能得到最终的结果
        //如果nums[i]的信封宽高小于dp[j]首位的宽高 条件a
        //或者如果nums[i]的信封宽高大于dp[j]末尾的宽高 条件b
        //则dp[i] = max(dp[j] +1) 其中j<i;需要记录最终max dp[j]时，j的值
        //并且根据situation[j][2]更新situation[i][2]的值，
        // 如果满足条件a，则更新situation[j][2]的第一个位置的值为nums[i]
        //如果瞒住条件b，则更新situation[j][2]的第二个位置的值为nums[j]
        int n = envelopes.length;
        int[] dp = new int[n];

        List[] situation = new List[n];
        //初始化
        dp[0] = 1;
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>(4);
        //list的位置0，1表示首节点
        list.add(envelopes[0][0]);
        list.add(envelopes[0][1]);
        //list的位置2，3表示尾几点
        list.add(envelopes[0][0]);
        list.add(envelopes[0][1]);
        lists.add(list);
        situation[0] = lists;

        for(int i=1;i<n;i++){
            int weight = envelopes[i][0];
            int height = envelopes[i][1];
            //记录更新dp[i]的最终j值，和更新首节点还是尾节点,方便更新最后的situation[i][2]
            Map<Integer,Integer> map = new HashMap<>();
            Integer maxJ = -1;
            //dp[i]与小于i的dp[j]均有关，遍历
           for(int j=0;j<i;j++){
                //取出dp[j]所对应的situation[j]
               List<List<Integer>> listJS = situation[j];
               for(List listOne:listJS){
                   if(weight < (Integer) listOne.get(0) && height < (Integer) listOne.get(1)){
                       //小于首节点情况
                       dp[i] = Math.max(dp[i],dp[j]+1);
                       maxJ = j;
                       map.put(maxJ,0);

                   }else if(weight > (Integer) listOne.get(2) && height < (Integer)listOne.get(3)){
                       //大于尾节点情况
                       dp[i] = Math.max(dp[i],dp[j]+1);
                       maxJ = j;
                       map.put(maxJ,1);
                   }
               }

           }
            //待更新的situation[i]
            List<Integer> temp = new ArrayList<>(4);
           //如果没有合适的，直接使用envelopes[i]更新首节点和尾
            if(maxJ == -1){
                //使用envelopes[i]更新首节点
                temp.add(envelopes[i][0]);
                temp.add(envelopes[i][1]);
                //使用envelopes[i]更新尾节点
                temp.add(envelopes[i][0]);
                temp.add(envelopes[i][1]);
                continue;
            }

           //更新situation[i][2]
            int flag = map.get(maxJ);
            List<Integer> listJ = situation[maxJ];

           if(flag == 0){
               //使用envelopes[i]更新首节点
               temp.add(envelopes[i][0]);
               temp.add(envelopes[i][1]);
               //listJ更新尾结点
               temp.add(listJ.get(2));
               temp.add(listJ.get(3));
               situation[i] = temp;
           }else if(flag == 1){
               //listJ更新首结点
               temp.add(listJ.get(2));
               temp.add(listJ.get(3));
               //使用envelopes[i]更新尾节点
               temp.add(envelopes[i][0]);
               temp.add(envelopes[i][1]);
               situation[i] = temp;
           }

        }
        return  dp[n-1];
    }

    public static void main(String[] args) {
        int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};
        System.out.println(maxEnvelopes(envelopes));
    }
}
