package autumn_leaves_collection_lcp19;


public class SolutionByAlex {

    public static int minimumOperations(String leaves) {
        //确定秋叶的数量，秋叶最终将分为红黄红三个部分，dp[i][0]表示第i片叶子为最终状态需要替换的次数
        //用dp[i][0]表示第一部分，即为首部分为红色的区域
        //用dp[i][1]表示第二部分，表示中间为黄色叶子的区域
        //用dp[i][2]表示第三部分，表示尾部为红色的区域
        //对于第一部分状态转移方程为：dp[i][0] = dp[i-1][0]+是否为红色（如果是红色就加0，如果是黄色就需要变换，加1）
        //特别的，对于dp数组的初始状态dp[0][0]为是否是红色，如果是红色dp[0][0]为0，如果是黄色，则dp[0][0]为1
        //对于第二部分转移方程为：dp[i][1] = min(dp[i-1][0],dp[i-1][1])+是否为黄色（如果是黄色就加0，如果是红色就需要变换，加1）
        //特别的，由于此题要求，每一种状态必须有一片叶子。所以第一片不能是状态1，也不能是状态2，并且第二片也不能是状态2
        //对于第三部分转移方程为：dp[i][2] = min(dp[i-1][1],dp[i-1][2})+是否为红色（如果是红色就加0，如果是黄色就需要变换，加1）
        int n = leaves.length();
        //初始化dp数组
        //
        int[][] dp = new int[n][3];
        dp[0][0] = leaves.charAt(0) == 'r' ? 0:1;
        //第一片叶子不能是状态1，2，第二片叶子不能是状态2
        dp[0][1] = dp[0][2] = dp[1][2] = Integer.MAX_VALUE;
        for(int i=1;i<n;i++){
            int isRed = leaves.charAt(i) == 'r' ? 0 : 1;
            int isYellow = leaves.charAt(i) == 'y' ? 0 : 1;
            dp[i][0] = dp[i-1][0] + isRed;
            dp[i][1] = Math.min(dp[i-1][0],dp[i-1][1]) + isYellow;
            if(i >= 2){
                //只有叶子数大于等于3才能进入状态2
                dp[i][2] = Math.min(dp[i-1][1],dp[i-1][2]) + isRed;
            }

        }
        return dp[n-1][2];
    }

    public static void main(String[] args) {
        String leaves = "yry";
        System.out.println(minimumOperations(leaves));
    }
}
