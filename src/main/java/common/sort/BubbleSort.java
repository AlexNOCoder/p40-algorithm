package common.sort;
/**
   * @author luoyuntian
   * @date 2020-08-22 17:25
   * @description 冒泡排序
    * @param
   * @return
   */
public class BubbleSort {
    public static int[] bubbleSort(int[] a) {
        if (a.length == 0) {
            return a;
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j + 1] < a[j]) {
                    int temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                }
            }

        }
        return a;
    }
}
