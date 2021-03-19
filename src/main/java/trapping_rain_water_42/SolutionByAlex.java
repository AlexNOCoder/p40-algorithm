package trapping_rain_water_42;

public class SolutionByAlex {
    /*
    给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     */
    //直接解法，前后看
    public static int trap(int[] height) {
        int n = height.length;
        int result = 0;
        for(int i=1;i<n;i++){
            //找到左边最高的点
            int leftMax = 0;
            for(int j=i-1;j>=0;j--){
                leftMax = Math.max(leftMax,height[j]);
            }

            //找到右边最高点

            int rightMax = 0;
            for(int k = i+1;k<n;k++){
                rightMax = Math.max(rightMax,height[k]);
            }


            //两边最高点的较小值作为高度，高度减去柱子的长度，就是雨水的量
            int rainHigh = Math.min(leftMax,rightMax);
            System.out.println(rainHigh);
            if(rainHigh > height[i]){
                result += (rainHigh-height[i]);
            }

        }

        return result;
    }
    //todo 动态规划、栈、双指针

    public static void main(String[] args) {
        int[] input = {4,2,0,3,2,5};
        System.out.println(trap(input));
    }
}
