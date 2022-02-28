package common.dp;

/**
 * @author luoyuntian
 * @program: p40-algorithm
 * @description: 打气球
 * @date 2022-02-27 16:08:43
 */
public class BurstBalloons {

    public static int maxScore1(int[] arr){
        // 处理首位
        int n = arr.length;
        int[] help = new int[n+2];
        help[0] =1;
        help[n+1] = 1;
        for(int i=1;i<=n;i++){
            help[i] = arr[i-1];
        }
        // [3,2,1,4,5]   --> [1,3,2,1,4,5,1]
        return process1(help,1,n);
    }
    // arr[L...R]上打爆气球，返回最大得分
    // 潜台词：arr[L-1]这个气球一定没爆，arr[R+1]这个气球一定也没爆。为了支持可能性展开
    public static  int process1(int[] arr,int L,int R){
        if(L == R){
            return arr[L-1]*arr[L]*arr[R+1];
        }

        // 不止一个气球
        // 分析可能性
        // 1) 最后打爆L位置的气球
        int p1= process1(arr,L+1,R) + arr[L-1]*arr[L]*arr[R+1];
        // 2） 最后打爆R位置的气球
        int p2 = process1(arr,L,R-1) + arr[L-1]* arr[R]*arr[R+1];

        int ans = Math.max(p1,p2);
        // 尝试中间每一个气球都最后打爆
        for(int mid=L+1;mid<R;mid++){
            // arr[mid]最后打爆
            int cur = process1(arr,L,mid-1) + process1(arr,mid+1,R)+arr[L-1]*arr[mid]*arr[R+1];
            ans = Math.max(ans,cur);
        }
        return ans;
    }



    // 加缓存of
    public static int maxScore2(int[] arr){
        // 处理首位
        int n = arr.length;
        // [3,2,1,4,5]   --> [1,3,2,1,4,5,1]
        int[] help = new int[n+2];
        help[0] =1;
        help[n+1] = 1;
        for(int i=1;i<=n;i++){
            help[i] = arr[i-1];
        }

        int[][] dp = new int[n+1][n+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                dp[i][j] = -1;
            }
        }

        return process2(help,1,n,dp);
    }
    // arr[L...R]上打爆气球，返回最大得分
    // 潜台词：arr[L-1]这个气球一定没爆，arr[R+1]这个气球一定也没爆。为了支持可能性展开
    public static  int process2(int[] arr,int L,int R,int[][] dp){
        if(dp[L][R] != -1){
            return dp[L][R];
        }
        int ans = 0;
        if(L == R){
            ans = arr[L-1]*arr[L]*arr[R+1];
        }else {
            // 不止一个气球
            // 分析可能性
            // 1) 最后打爆L位置的气球
            int p1= process2(arr,L+1,R,dp) + arr[L-1]*arr[L]*arr[R+1];
            // 2） 最后打爆R位置的气球
            int p2 = process2(arr,L,R-1,dp) + arr[L-1]* arr[R]*arr[R+1];
            ans = Math.max(p1,p2);
            // 尝试中间每一个气球都最后打爆
            for(int mid=L+1;mid<R;mid++){
                // arr[mid]最后打爆
                int cur = process2(arr,L,mid-1,dp) + process2(arr,mid+1,R,dp)+arr[L-1]*arr[mid]*arr[R+1];
                ans = Math.max(ans,cur);
            }
        }
        dp[L][R] = ans;
        return ans;
    }



}
