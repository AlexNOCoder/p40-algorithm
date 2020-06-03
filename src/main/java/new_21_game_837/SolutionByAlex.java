package new_21_game_837;


public class SolutionByAlex {

    public double new21Game(int N, int K, int W) {
        double[] sum = new double[K+W];
        if(K ==0){
            return 1.0;
        }
        //分段函数
        for(int i=0;i<K+W;i++){
            //i <= k && i <= w : p[i] = sum[i-1]/w

            //i <= k && i > w : p[i] = (sum[i-1] - sum[i-w-1])/w

            //i > k && i <= w : p[i] = sum[K-1]/w

            //i > k && i > w : p[i] = (sum[K-1] - sum[i-W-1])/w
         }
        return 0.0;
    }
}
