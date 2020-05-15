package assign_cookies_455;
public class SolutionByAlex {

    public static void main(String[] args) {
        int [] test1 = {10,9,8,7};
        int [] test2 = {5,6,7,8};
        findContentChildren(test1,test2);
    }

    public static int findContentChildren(int[] g, int[] s) {
        //快排速度比冒泡提升了百倍
        quickSort(g,0,g.length-1);
        quickSort(s,0,s.length-1);
        int result = 0;
        for(int i=0,j=0;i < g.length && j<s.length; ){
            if(g[i] <= s[j]){
                //满足胃口
                result++;
                i++;
                j++;
            }else {
                j++;
            }
        }
        return result;

    }

    //冒泡排序
    public static void  sortArray(int[] original){
        for(int i = original.length;i >0 ;i--){
            for(int j = 0; j< i-1;j++){
                if(original[j+1] < original[j]){
                    int temp = original[j+1];
                    original[j+1] = original[j];
                    original[j] = temp;
                }
            }
        }
    }

    //快排
    private static void quickSort(int[] num, int left, int right) {
        if(left>=right) {
            return;
        }
        int key=num[left];
        int i=left;
        int j=right;
        while(i<j){
            while(num[j]>=key && i<j){
                j--;
            }
            while(num[i]<=key && i<j){
                i++;
            }
            if(i<j){
                int temp=num[i];
                num[i]=num[j];
                num[j]=temp;
            }
        }
        num[left]=num[i];
        num[i]=key;
        quickSort(num,left,i-1);
        quickSort(num,i+1,right);
    }

}
