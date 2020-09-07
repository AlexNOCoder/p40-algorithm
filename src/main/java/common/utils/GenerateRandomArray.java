package common.utils;
public class GenerateRandomArray {
    /**
       * @author luoyuntian
     *            生成随机数组
     * Math.random()  [0,1)
     * Math.random() * N [0,N]
     * (int)(Math.random() * N)  [0,N-1]
       */
    public static int[] generateRandomArray(int maxSize,int maxValue){
        int[] arr = new int[(int) ((maxSize +1) * Math.random())];
        for(int i = 0;i < arr.length;i++){
            // [-?,+?]
            arr[i] = (int) ((maxValue + 1)* Math.random()) - (int)(maxValue * Math.random());
        }
        return arr;
    }

    public static boolean isEqual(int[] arr1,int[] arr2){
        if((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)){
            return false;
        }
        if(arr1 == null && arr2 == null){
            return true;
        }
        if(arr1.length != arr2.length){
            return false;
        }
        for(int i=0; i< arr1.length;i++){
            if(arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }

}
