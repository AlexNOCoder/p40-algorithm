package common.other;

/**
 * @author luoyuntian
 * @program: p40-algorithm
 * @description: 数组实现栈
 * @date 2022-03-01 21:27:42
 */
public class ArrayStack {
    // 数组
    private int[] nums;
    // 栈中元素个数
    private int count;
    // 初始化数组，申请一个大小为n的数组空间
    public ArrayStack(int n){
        this.nums = new int[n];
        this.count = 0;
    }

    // 入栈操作
    public boolean push(int n){
        // 数组空间不够，直接返回false，入栈失败。没有扩容
        // num.len * 2 arraycopy
        if(count >= nums.length){
            return false;
        }
        // 将item放到下标为count的位置，并且count加一
        nums[count] = n;
        count ++;
        return true;
    }

    // 出栈操作
    public int pop(){
        // 栈为空，则直接返回0
        if(count == 0 ){
            return 0;
        }
        // 返回下标为count-1的数组元素，并且栈中元素个数count减一
        int n = nums[count-1];
        count --;
        return n;
    }

}
