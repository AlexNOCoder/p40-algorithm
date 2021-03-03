package counting_bits_338;

import java.util.Arrays;

public class SolutionByAlex {

    public static int[] countBits(int num) {
        int [] result = new int[num+1];
        for(int i=0;i<=num;i++){
            result[i] = binaryNum(i);
        }
        return result;
    }

    public static int binaryNum(int num){
        String binaryNum = Integer.toBinaryString(num);
        System.out.println(num+":"+binaryNum);
        char[] chars = binaryNum.toCharArray();
        int count = 0;
        for(char c: chars){
            if(c == '1'){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(5)));
    }
}


