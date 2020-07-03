package roman_numeral_conversion_13;

/**
 * @program: p40-algorithm
 * @description: 罗马数字转换
 * @author: lijie
 * @create: 2020-07-01 14:36
 */
public class SolutionByJack {

    private int getValue(char ch){
        switch(ch){
            case 'I' : return 1;
            case 'Ⅴ': return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
            default: return 0;
        }
    }

    public int romanToInt(String s){
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i ++){
            int num = getValue(s.charAt(i));
            if (preNum < num){
                sum -= preNum;
            }else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }
}
