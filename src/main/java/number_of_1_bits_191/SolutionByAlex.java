package number_of_1_bits_191;

public class SolutionByAlex {
    public int hammingWeight(int n) {
        String number = Integer.toBinaryString(n);
        int result = 0;
        for(int i=0;i<number.length();i++){
            if(number.charAt(i) == '1'){
                result++;
            }
        }
        return result;
    }
}
