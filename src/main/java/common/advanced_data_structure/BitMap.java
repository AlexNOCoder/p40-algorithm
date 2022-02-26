package common.advanced_data_structure;

/**
 * @author luoyuntian
 * @program: p40-algorithm
 * @description: 位图
 * @date 2022-02-26 20:39:57
 */
public class BitMap {
    public static void main(String[] args) {
        int a = 0;
        // 让31进入到a
        a = a|(a << 31);
        // 31 有没有出现
        int status = a & (1 << 31);
        if(status == 0){
            System.out.println("31没有出现!");
        }else{
            System.out.println("31出现了！");
        }
        // arr[0] -> 0~31
        // arr[1] -> 32~63
        // 10个整数，320位，0~319
        int[] arr = new int[10];
        int num = 173;
        int kth = 173/32;

        // 让num进入arr
        arr[num/32] = arr[num/32] |(1 <<(num % 32));
        // 用位图512M可以把32位无符号整数表示
    }
}
