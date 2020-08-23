package sort;
public class SelectSort {
    public static int[] selectSort(int[] array){
        if(array.length ==0){
            return array;
        }
        for(int i=0;i<array.length;i++){
            int minIndex = 1;
            for(int j=1;j<array.length;j++){
                if(array[j] < array[minIndex]){
                    minIndex = j;
                }
                int temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
            }
        }
        return  array;
    }

}
