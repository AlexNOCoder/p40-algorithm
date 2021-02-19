package max_consecutive_ones_3_1004;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luoyuntian
 * 暴力解：
 * 对于有m个空位，k个可转换次数，则有Cmk次调整的可能，将每种可能的最大长度求出
 */
public class SolutionByAlex {
    public static int longestOnes(int[] A, int K) {
        //初始最大长度为0
        int maxLength = 0;

        //初始化zero数组
        List<Integer> zeroList = new ArrayList<>();
        for(int i=0;i<A.length;i++){
            if(A[i] == 0){
                zeroList.add(i);
            }
        }

        //调整
        //游标,从0到A.length -k
        int cur = 0;
        while(cur < (A.length-K)){

        }


        return 0;
    }


    public static int findLongestOnes(int[] A){
        int maxLength = 0;
        for(int i=0,j=0;j<A.length;){
            if(A[j] == 1){
                j++;
            }else {
                //本段1的长度
                int tempLength = j-i;
                //更新maxLength
                maxLength = Math.max(maxLength,tempLength);
                //双游标后移
                j++;
                i=j;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] A = {1,1,1,1,1,1,1,1,1,1,0};
        System.out.println(findLongestOnes(A));
    }
}

