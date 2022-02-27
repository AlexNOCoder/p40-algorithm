package common.dp;

/**
 * @author luoyuntian
 * @program: p40-algorithm
 * @description: 纸牌游戏
 * @date 2022-02-27 15:24:13
 */
public class CardsInLine {
    // 递归实现
    public static int getWinnerScore1(int[] arr){
        int xian = xian1(arr,0,arr.length-1);
        int hou = hou1(arr,0,arr.length-1);
        return Math.max(xian,hou);
    }
    // 目前，是在arr[L...R]这个范围上玩牌
    // 返回先手最终的最大得分
    public static int xian1(int[] arr,int L,int R){
        // 只有最后一张牌
        if(L == R){
            return arr[L];
        }
        // 还剩两张牌
        if(L == R -1){
            return Math.max(arr[L],arr[R]);
        }
        // L...R上，不止两张牌
        // 可能1：拿走L位置的牌
        int p1 = arr[L] + hou1(arr,L+1,R);
        // 可能2：拿走R位置的牌
        int p2 = arr[R] + hou1(arr,L,R-1);

        return Math.max(p1,p2);
    }
    // 目前，是在arr[L...R]这个范围上玩牌
    // 返回后手最终的最大得分
    public static int hou1(int[] arr,int L,int R){
        // 只剩一张牌，被先手拿走
        if(L == R){
            return 0;
        }
        // 剩下两张牌，大的被先手拿走，只能拿小的
        if(L == R-1){
           return Math.min(arr[L],arr[R]);
        }
        // L...R上，不止两张牌
        // 后手！
        // 可能性1：对手，先手，拿走L位置的牌，接下来，你就可以在L+1...R上先手了
        int p1 = xian1(arr,L+1,R);
        // 可能性2：对手，先手，拿走R位置的牌，接下来，你就可以在L...R-1上先手了
        int p2 = xian1(arr,L,R-1);
        return Math.max(p1,p2);
    }


    // 加缓存
    public static int getWinnerScore2(int[] arr){
        int n = arr.length;
        int[][] dpxian = new int[n][n];
        int[][] dphou = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dpxian[i][j] = -1;
                dphou[i][j] = -1;
            }
        }
        int xian = xian2(arr,0,arr.length-1,dpxian,dphou);
        int hou = hou2(arr,0,arr.length-1,dpxian,dphou);
        return Math.max(xian,hou);
    }
    // 目前，是在arr[L...R]这个范围上玩牌
    // 返回先手最终的最大得分
    public static int xian2(int[] arr,int L,int R,int[][] dpxian ,int[][] dphou ){
        // 算过
        if (dpxian[L][R] != -1) {
            return dpxian[L][R];
        }
        int ans = 0;

        // 只有最后一张牌
        if(L == R){
            ans = arr[L];
        }else if(L == R -1){
            // 还剩两张牌
            ans =  Math.max(arr[L],arr[R]);
        }else {
            // L...R上，不止两张牌
            // 可能1：拿走L位置的牌
            int p1 = arr[L] + hou2(arr,L+1,R,dpxian,dphou);
            // 可能2：拿走R位置的牌
            int p2 = arr[R] + hou2(arr,L,R-1,dpxian,dphou);
            ans = Math.max(p1,p2);
        }
        dpxian[L][R] = ans;

        return ans;
    }
    // 目前，是在arr[L...R]这个范围上玩牌
    // 返回后手最终的最大得分
    public static int hou2(int[] arr,int L,int R,int[][] dpxian,int[][] dphou){
        if(dphou[L][R] != -1){
            return dphou[L][R];
        }
        int ans=0;
        // 只剩一张牌，被先手拿走
        if(L == R){
            return 0;
        }else  if(L == R-1){
            // 剩下两张牌，大的被先手拿走，只能拿小的
            ans =  Math.min(arr[L],arr[R]);
        }else {
            // L...R上，不止两张牌
            // 后手！
            // 可能性1：对手，先手，拿走L位置的牌，接下来，你就可以在L+1...R上先手了
            int p1 = xian2(arr,L+1,R,dpxian,dphou);
            // 可能性2：对手，先手，拿走R位置的牌，接下来，你就可以在L...R-1上先手了
            int p2 = xian2(arr,L,R-1,dpxian,dphou);
            ans = Math.max(p1,p2);
        }
        dphou[L][R] = ans;
        return ans;
    }
}
