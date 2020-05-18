package assign_cookies_455;

/**
 * @Author: lengpei
 * @DATE: 2020/5/18
 **/
public class SolutionByLp {

    //胃口值g
    public static int findContentChildren(int[] g, int[] s) {
        if(s.length==0){
            return 0;
        }
        sort(g);
        sort(s);
        int num = 0;
        int si = 0;
        for(int i = 0;i<g.length;i++){
            while (g[i]>s[si] && si<s.length-1){
                si++;
            }
            if(g[i]<=s[si]){
                num+=1;
                si++;
            }
            if(si == s.length){
                break;
            }
        }
        return num;
    }

    //冒泡 ，各位快排牛逼
    public static void sort(int[] array){
        for(int i = 0 ;i<array.length;i++){
            for(int j = 0;j<i;j++){
                if (array[i]<array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
}
