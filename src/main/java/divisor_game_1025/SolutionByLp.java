package divisor_game_1025;

/**
 * @Author: lengpei
 * @DATE: 2020/5/19
 **/
public class SolutionByLp {
    /**
     * 动态
     * @param N
     * @return
     */
    public boolean divisorGame(int N) {
        if(N==1){
            return false;
        }
        if(N==2){
            return true;
        }
        boolean[] s = new boolean[N];
        s[0] = false;
        s[1] = true;
        for(int i = 1;i<N;i++){
            s[i] = !s[i-1];
        }
        return s[N-1];
    }

    /**
     * 归纳法牛逼
     * @param N
     * @return
     */
    public boolean divisorGame2(int N) {
        return N%2==0;
    }
}
