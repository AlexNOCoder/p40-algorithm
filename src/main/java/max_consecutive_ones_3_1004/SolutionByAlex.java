package max_consecutive_ones_3_1004;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * @author luoyuntian
 * 暴力解：
 * 对于有m个空位，k个可转换次数，则有Cmk次调整的可能，将每种可能的最大长度求出
 */
public class SolutionByAlex {

    public static Stack<Integer> stack = new Stack<Integer>();
    public static List<Stack<Integer>> list = new ArrayList<>();
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
        int[] zeroArr = new int[zeroList.size()];
        for(int j=0;j<zeroList.size();j++){
            zeroArr[j] = zeroList.get(j);
        }
        //调整
        //游标,从0到A.length -k
        f3(zeroArr,K,0,0);

        for(Stack<Integer> s:list){
            int[] temp = new int[s.size()];
            int i=0;
            Iterator<Integer> iterator = s.iterator();
            if(iterator.hasNext()){
                temp[i] = iterator.next();
                i++;
            }
            maxLength = Math.max(maxLength,findLongestOnes(temp));
        }


        return maxLength;
    }


    public static int findLongestOnes(int[] A){
        printArr(A);
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


    public static void f3(int[] shu, int targ, int has, int cur){
        if(has == targ) {
            System.out.println("***");
            System.out.println(stack);
            Stack<Integer> temp = new Stack<>();
            Iterator<Integer> iterator = stack.iterator();
            if(iterator.hasNext()){
                temp.push(iterator.next());

            }
            list.add(temp);
            return;
        }

        for(int i=cur;i<shu.length;i++) {
            if(!stack.contains(shu[i])) {
                stack.add(shu[i]);
                f3(shu, targ, has+1, i);
                stack.pop();
            }
        }
    }

    public static void printArr(int[] s){
        for(int i:s){
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] A = {1,1,1,0,0,0,1,1,1,1,0};
        printArr(A);
        System.out.println("===============");
        System.out.println("maxLength"+longestOnes(A,2));
    }
}

