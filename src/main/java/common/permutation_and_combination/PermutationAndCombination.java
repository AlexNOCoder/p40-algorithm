package common.permutation_and_combination;

import java.util.Stack;

/**
 * @author luoyuntian
 * 排列组合java 递归实现
 */
public class PermutationAndCombination {
    public static Stack<Integer> stack = new Stack<Integer>();
    //可重复的全排列
    /**
     *
     * @param shu   待选择的数组
     * @param targ  要选择多少个次
     * @param cur   当前选择的是第几次
     */
    public static void f1(int[] shu, int targ, int cur){
        if(cur == targ) {
            System.out.println(stack);
            return;
        }

        for(int i=0;i<shu.length;i++) {
            stack.add(shu[i]);
            f1(shu, targ, cur+1);
            stack.pop();

        }
    }

    //不可重复的全排列
    /**
     *
     * @param shu   待选择的数组
     * @param targ  要选择多少个次
     * @param cur   当前选择的是第几次
     */
    public static void f2(int[] shu, int targ, int cur){
        if(cur == targ) {
            System.out.println(stack);
            return;
        }

        for(int i=0;i<shu.length;i++) {
            if(!stack.contains(shu[i])) {
                stack.add(shu[i]);
                f2(shu, targ, cur+1);
                stack.pop();
            }
        }
    }

    //不可重复的非全排列
    /**
     *
     * @param shu  元素
     * @param targ  要选多少个元素
     * @param has   当前有多少个元素
     * @param cur   当前选到的下标
     *
     * 1    2   3     //开始下标到2
     * 1    2   4     //然后从3开始
     */
    public static void f3(int[] shu, int targ, int has, int cur){

        if(has == targ) {
            System.out.println(stack);
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

    public static void main(String[] args) {
        int[] shu = {1,4,7,9,10};
        f3(shu,3,0,0);
    }
}
