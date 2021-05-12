package _132_pattern_456;

import java.util.Stack;


public class SolutionByAlex {
    //单调栈，保证栈顶的元素是最小的
    public static boolean find132pattern(int[] nums) {
        int n = nums.length;
        int[] min = new int[n];
        min[0] = nums[0];   // 第一个位置的最小数肯定就是它自己了
        // 将前一个位置的最小数和当前位置的数比较，找到当前位置的最小数
        for (int i = 1; i < n; ++i){
            min[i] = Math.min(min[i - 1], nums[i]);
        }
        Stack<Integer> stack = new Stack<>();
        // 从后往前遍历，stack 中的数字表示的是从位置 i 到 n 中，大于 min[i] 且小于 nums[i] 的数
        for (int i = n - 1; i >= 0; --i) {
            if (nums[i] > min[i]) {
                // 如果栈中的数字比 min[i] 还小或者相同，那么说明不可能是 ak，就弹出来
                while (!stack.isEmpty() && stack.peek() <= min[i]) stack.pop();
                // 检查一下栈顶元素是不是满足 ai<stack.peek()<aj，如果满足就说明找到了
                if (!stack.isEmpty() && stack.peek() < nums[i]) return true;
                // 不管怎样都要push进来当前的数，因为当前的数满足了大于 min[i]
                stack.push(nums[i]);
            }
        }
        // 到最后都没找到，肯定只能返回false了
        return false;
    }
    public static void main(String[] args) {
        int[] input = {-2,1,2,-2,1,2};
        find132pattern(input);
    }
}