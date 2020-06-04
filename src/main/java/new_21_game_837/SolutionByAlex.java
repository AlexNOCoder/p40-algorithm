package new_21_game_837;


public class SolutionByAlex {

    public static void main(String[] args) {
        System.out.println(new21Game(21,17,10));
    }


    public static double new21Game(int N, int K, int W) {
        double[] sum = new double[K+W];
        double[] p = new double[K+W];
        if(K ==0){
            return 1.0;
        }
        sum[0] = 1;
        p[0] = 1;
        //分段函数 以 N=21；K=17；W=10为例
        for(int i=1;i<K+W;i++){
            //i <= k && i <= w : p[i] = sum[i-1]/w
            //eg. i=7
            if(i <=K && i<= W){
                p[i] = sum[i-1]/W;

            }

            //i <= k && i > w : p[i] = (sum[i-1] - sum[i-w-1])/w
            //eg. i = 13
            if(i <=K && i > W){
                p[i] = (sum[i-1] - sum[i-W-1])/W;

            }

            //i > k && i <= w : p[i] = (sum[i-1] - sum[i-w-1])/w
            //eg. i = 13
            if(i > K && i <= W){
                p[i] = sum[K-1]/W;

            }

            //i > k && i > w : p[i] = (sum[K-1] - sum[i-W-1])/w
            //eg. i = 20
            if(i > K && i > W){
                p[i] = (sum[K-1] - sum[i-W-1])/W;
            }
            sum[i]= sum[i-1]+p[i];

         }
        return (sum[N] - sum[K-1])/(sum[K+W-1] - sum[K-1]);
    }
}
