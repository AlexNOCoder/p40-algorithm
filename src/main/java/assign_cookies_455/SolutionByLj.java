package assign_cookies_455;

/**
 * @version 1.0
 * @author： lijie
 * @date： 2022-04-18 21:09
 */
public class SolutionByLj {

    public static void main(String[] args){
        int [] test1 = {10,9,8,7};
        int [] test2 = {5,6,7,8};
        findContentChildren(test1, test2);
    }

    public static int findContentChildren(int[] g, int[] s){
        sort(g);
        sort(s);
        int numOfChildren = g.length, numOfCookies = s.length;
        int count = 0;
        for (int i = 0, j = 0; i < numOfChildren && j < numOfCookies; i ++, j ++){
            while(j < numOfCookies && g[i] > s[j]){
                j ++;
            }
            if (j < numOfCookies){
                count ++;
            }
        }
        System.out.println(count);
        return count;
    }


    //冒泡排序
    private static void sort(int[] arr){
        for (int i = arr.length; i > 0; i --){
            for (int j = 0; j < i - 1; j ++){
                if (arr[j + 1] < arr[j]){
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }

    }
}
