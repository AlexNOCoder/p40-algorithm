package common.sort;

import java.util.*;

/**
 * @author luoyuntian
 * @program: p40-algorithm
 * @description: 桶排序
 * @date 2022-03-02 20:50:55
 */
public class BucketSort {
    public static double[] bucketSort(double[] array){
        double max = 0;
        double min = 0;
        // 获取最大值和最小值之间的差
        for(int i=0;i<array.length;i++){
            if(array[i] > max){
                max = array[i];
            }
            if(array[i] < min){
                min = array[i];
            }
        }
        double d = max - min;
        // 桶初始化
        int bucketNum = array.length;
        ArrayList<LinkedList<Double>> bucketList = new ArrayList<LinkedList<Double>>(bucketNum);

        for(int i=0;i < bucketNum;i++){
            bucketList.add(new LinkedList<Double>());
        }
        //将每个元素放入桶中
        for(int i=0;i < array.length;i++){
            int num = (int) ((array[i] - min) * (bucketNum - 1)/d);
            bucketList.get(num).add(array[i]);
        }
        //对每个桶内部进行排序
        for(int i=0;i < bucketList.size();i++){
            Collections.sort(bucketList.get(i));
        }
        // 输出全部元素
        double[] sortedArray = new double[array.length];
        int index = 0;
        for(LinkedList<Double> list:bucketList){
            for(double element:list){
                sortedArray[index] = element;
                index++;
            }
        }
        return sortedArray;
    }

    public static void main(String[] args) {
        double[] array = {4.12,6.421,0.0023,3.0,2.123,8.122,4.12,10.09};
        double[] sortedArray = bucketSort(array);
        System.out.println(Arrays.toString(sortedArray));
    }
}
