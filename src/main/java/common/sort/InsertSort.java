package common.sort;
public class InsertSort {
    public static int[] inserSort(int[] arry){
        if(arry.length == 0){
            return arry;
        }
        int cur;
        for(int i=0;i<arry.length-1;i++){
            cur = arry[i+1];
            int preIndex = i;
            while(preIndex >=0 && cur < arry[preIndex]){
                arry[preIndex+1] = arry[preIndex];
                preIndex --;
            }
            arry[preIndex +1] = cur;
        }
        return arry;
    }
}
