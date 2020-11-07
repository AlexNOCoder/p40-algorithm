package common.dp;
public class CoinChange {
    //int[] A ={2,5,7}
    //M=27
    public static int coinChange(int[] A,int M){
        //对于数组空间开辟多大要具体情况具体分析
        // 当需要用到0.....n的坐标都要用到，[n+1]
        // 当需要用到0.....n-1的坐标时，[n]
        int[] f= new int[M+1];//着重注意点1：数组大小
        //有多少种硬币
        int n= A.length;
        //初始化
        f[0] =0;//着重注意点2：初始化

        //f[1],f[2],...,f[27]
        for(int i=1;i<=M;++i){//着重注意点3：遍历顺序
         //先给其赋值为无穷大
         f[i] = Integer.MAX_VALUE; //着重注意点4：不可达处理，由于求最小值，一般用无穷大，如果使用其他值，在使用Math.min时就要注意细节了
            //last = coin A[j]，且f(i) = min(f[i-A[0]]+1,...,f[i-A[n-1]]+1
            //f[X] = min{f[X-2]+1,f[X-5]+1,f[X-7]+1}
            for(int j=0;j<n;++j){
                //边界条件1：硬币面值要小于等于目标金额
                //边界条件2：如果f[i - A[j]]已经是无穷大了，直接pass，不然再+1会int越界
                if(i >= A[j] && f[i - A[j]] != Integer.MAX_VALUE){ //着重注意点5：边界情况处理

                    f[i] = Math.min(f[i-A[j]]+1,f[i]);//着重注意点6：转移方程
                }
            }
        }
        //根据题目要求，找不到返回-1
        if(f[M] == Integer.MAX_VALUE){
            f[M] = -1;
        }
        return f[M];
    }

    public static void main(String[] args) {
        int[] coins = {2,5,7};
        System.out.println(coinChange(coins,27));
    }
}
