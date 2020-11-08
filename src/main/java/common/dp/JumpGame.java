package common.dp;
public class JumpGame {
    //可使用贪心，时间复杂度更低O(N),使用每次跳最远的贪心策略
    public static boolean jumpGame(int[] A){
        int n = A.length;
        //0到n-1块石头
        boolean[] f = new boolean[n];
        //初始化
        f[0] = true;

        //从前往后遍历
        for(int i=1; i<n;++i){
            //先设置为不可达
            f[i] = false;
            //前一个石头 j
            //最后一条是从 j 到 i
            for(int j=0;j < i;++j){
                //条件： j可达，并且j可以跳到i
                if(f[j] && j + A[j] >= i){
                    //状态转移
                    f[i] = true;
                    break;
                }
            }
        }

        //结果为f[n-1]
        return f[n -1];
    }

    //测试是否数组寻址
    public static void main(String[] args) {
        int[][] testArr = new int[10000][10000];
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10000;i++){
            for(int j=0;j<10000;j++){
                testArr[i][j] =0;
            }
        }
        long end1 = System.currentTimeMillis();

        System.out.println("顺序访问耗时： "+(end1-start1));
        long start2 = System.currentTimeMillis();
        for(int i=0;i<10000;i++){
            for(int j=0;j<10000;j++){
                testArr[j][i] =0;
            }
        }
        long end2 = System.currentTimeMillis();
        System.out.println("非顺序访问耗时： "+(end2-start2));

    }
}
