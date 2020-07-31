package roman_numeral_conversion_13;

public class SolutionByAlex {

    public static void main(String[] args) {
        String str = "IV";
        System.out.println(romanToInt(str));
    }

    public static int romanToInt(String s) {
        char[] s2chars = s.toCharArray();
        int count =0;
        int i=0;
        for(;i < s2chars.length;i++){
            if(i+1 < s2chars.length){
                String ss = ""+s2chars[i]+s2chars[i+1];
                if(getNumberFromStr(ss) != 0){
                    count += getNumberFromStr(ss);
                    i++;
                    continue;
                }else{
                    count += getNumberFromChar(s2chars[i]);
                }
            }
            if(i == s2chars.length-1){
                count += getNumberFromChar(s2chars[s2chars.length-1]);
            }
        }

        return count;
    }


    public static int getNumberFromStr(String s){
        switch (s){
            case "IV":
                return 4;
            case "IX":
                return 9;
            case "XL":
                return 40;
            case "XC":
                return 90;
            case "CD":
                return 400;
            case "CM":
                return 900;
            default :
                return 0;
        }
    }

    public static int getNumberFromChar(char c){
        switch (c){
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default :
                return 0;
        }

    }
}
