package climb_stairs_70;

/**
 * @Author: lengpei
 * @DATE: 2020/5/19
 **/
public class ByLp {
    public int climbStairs(int n) {
        if (n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        if(n==3){
            return 3;
        }
        int[] s = new int[n];
        s[0] = 1;
        s[1] = 2;
        s[2] = 3;
        for(int j=3 ; j<n;j++){
            s[j] = s[j-1]+s[j-2];
        }
        return s[n-1];
    }
}
