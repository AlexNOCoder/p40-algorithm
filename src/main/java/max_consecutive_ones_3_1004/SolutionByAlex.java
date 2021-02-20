package max_consecutive_ones_3_1004;

import java.util.*;

/**
 * @author luoyuntian
 * 暴力解：
 * 对于有m个空位，k个可转换次数，则有Cmk次调整的可能，将每种可能的最大长度求出
 * 时间复杂度太高，不能通过
 *
 * 窗口滑动解：
 * 将【最多可以把K个0变成1，求仅包含1的最长子数组的长度】转化为【找出一个最长的子数组，改子数组最多允许有K个0】
 */
public class SolutionByAlex {

    public static int longestOnes(int[] A,int K){
        //最大长度
        int maxLength = 0;
        //左指针位置
        int left = 0;
        //右指针位置
        int right = 0;
        //区间内0的数量
        int tempZeroSize =0;
        while(right < A.length){
            //如果为1，right++
            //如果为0，tempZeroSize++,且0的数量小于等于k，right++
            //如果为0，tempZeroSize++,且0的数量大于k，更新maxLength的值，将left移动到区间内zero个数等于k的位置，right++,tempZeroSize--
//            if(A[right] == 1){
//                right++;
//            }else {
//                //当前窗口zero数量+1
//                tempZeroSize++;
//                if(tempZeroSize <=K){
//                    right++;
//                }else {
//                    maxLength = Math.max(maxLength,right-left+1);
//                    while(A[left] != 0){
//                        left ++;
//                    }
//                    right++;
//                    tempZeroSize --;
//                }
//            }
//            int[] A = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
            if(A[right] == 0){
                tempZeroSize++;
            }

            //移动left到合适位置
            while (tempZeroSize > K){
                if(A[left++]==0){
                    tempZeroSize--;
                }
            }
            maxLength = Math.max(maxLength,right-left+1);
            right++;
        }
        return maxLength;
    }





    public static Stack<Integer> stack = new Stack<Integer>();
    public static List<Stack<Integer>> list = new ArrayList<>();
    public static int longestOnes2(int[] A, int K) {
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
            int[] temp = deepCopyArr(A);
            Iterator<Integer> iterator = s.iterator();
            while(iterator.hasNext()){
                int index = iterator.next();
                temp[index] = 1;
                System.out.print(index);
                System.out.print(" ");
            }
            System.out.println();
            System.out.println(Arrays.toString(temp));;
            maxLength = Math.max(maxLength,findLongestOnes(temp));
        }


        return maxLength;
    }


    public static int findLongestOnes(int[] A){
        int maxLength = 0;
        for(int i=0,j=0;j<= A.length;){
            if(j<A.length && A[j] == 1){
                j++;
            }else {
                if(j == A.length-1 && A[j] == 1){
                    j++;
                }
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
            Stack<Integer> temp = new Stack<>();
            Iterator<Integer> iterator = stack.iterator();
            while(iterator.hasNext()){
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

    public static int[] deepCopyArr(int[] org){
        if(org != null && org.length >0){
            int[] copy = new int[org.length];
            for(int i=0;i<org.length;i++){
                copy[i] = org[i];
            }
            return copy;
        }else {
            return org;
        }
    }

    public static void main(String[] args) {
        int[] A = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        System.out.println(longestOnes(A,3));
    }
}

