package largest_rectangle_n_histogram_84;


import java.util.Stack;

public class SolutionByAlex {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int max = 0;
        Stack<Integer> stack = new Stack<Integer>();

        for(int i=0;i<=n;i++){
            // 一旦发现当前高度比堆栈顶端锁记录的高度要矮，即可以开始对堆栈顶端记录的高度计算面积了
            // 此处巧妙处理了当i等于n的情况
            // 同事判断当前面积是否为最大值
            while(!stack.isEmpty() && (i==n || heights[i] < heights[stack.peek()])){
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i:i-1-stack.peek();
                max = Math.max(max,width * height);

            }
            // 如果当前的高度比堆栈顶端的所记录的高度要高，则压入堆栈
            stack.push(i);
        }
        // 返回面积的最大值
        return max;
    }

}
