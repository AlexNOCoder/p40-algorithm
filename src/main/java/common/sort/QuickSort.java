package common.sort;
public class QuickSort {
    //快排
    private static void quickSort(int[] num, int left, int right) {
        if(left>=right) {
            return;
        }
        int pivot=num[left];
        int i=left;
        int j=right;
        while(i<j){
            while(num[j]>=pivot && i<j){
                j--;
            }
            while(num[i]<=pivot && i<j){
                i++;
            }
            if(i<j){
                int temp=num[i];
                num[i]=num[j];
                num[j]=temp;
            }
        }
        num[left]=num[i];
        num[i]=pivot;
        quickSort(num,left,i-1);
        quickSort(num,i+1,right);
    }
}
