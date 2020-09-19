package string_to_integer_8;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SolutionByAlex {
    public static void main(String[] args) {
        System.out.println(myAtoi(" -42"));
//        System.out.println(removeAntiNumber("123abc"));
    }
    public static int myAtoi(String str) {
        //1.trim去掉空白
        String trimedStr = str.trim();
        boolean isNegative = false;
        String numStr;
        //2.判断是否是负号
        if(trimedStr.startsWith("-")){
            //3.如果是负号判断负号后面的字符串
            //4.如果是数字则取到数字字符串的末尾，然后转换成数字返回
            isNegative = true;
            String temp;
            if(trimedStr.contains(" ")){
                temp = trimedStr.substring(1).split(" ")[0];
            }else {
                temp = trimedStr;
            }
            temp = removeAntiNumber(temp);
            if(temp.startsWith("+")){
                return 0;
            }
            if(temp.equals("") || !isNumber(temp)){
                return 0;
            }
            //处理正数前的0
            temp = removeZero(temp);
            numStr = "-"+temp;

        }else {
            //3.如果不是负号则判断是否是非数字开头，非数字则返回0
            //4.如果是数字则取到数字字符串的末尾，然后转换成数字返回
            String temp;
            if(trimedStr.contains(" ")){
                 temp = trimedStr.split(" ")[0];
            }else {
                temp = trimedStr;
            }

            temp = removeAntiNumber(temp);
            if(temp.startsWith("+-")){
                return 0;
            }
            //处理正数前的0
            if(temp.startsWith("+")){
                temp = temp.substring(1);
            }
            temp = removeZero(temp);

            if(isNumber(temp)){
                numStr = temp;
            }else {
                return 0;
            }

        }

        if(isNegative){
            //是负数
            //5.如果是数字，但是超过了INT的最大或最小值，则返回INT型最大或最小值
            if(numStr.length()>11){
                return Integer.MIN_VALUE;
            }else {
                double numDouble = Double.valueOf(numStr);
                if(numDouble < Integer.MIN_VALUE){
                    return Integer.MIN_VALUE;
                }else {
                    return (int)numDouble;
                }
            }
        }else{
            //是正数
            if(numStr.length()>10){
                return Integer.MAX_VALUE;
            }else {
                double numDouble = Double.valueOf(numStr);
                if(numDouble > Integer.MAX_VALUE){
                    return Integer.MAX_VALUE;
                }else {
                    return (int)numDouble;
                }
            }

        }
    }

    public static String removeZero(String temp){
        if(temp.startsWith("0")){
            char[] tempChars = temp.toCharArray();
            int i=0,j=1;
            for(;j<temp.length();i++,j++){
                if(tempChars[i] =='0' && tempChars[j] != '0'){
                    break;
                }
            }
            //如果全是0
            if(j == temp.length()){
                return "0";
            }

            if(tempChars[j] !='.'){
                //如果零后不是.
                temp = temp.substring(j);
            }else {
                //如果是小数
                temp = temp.substring(i);
            }
        }
        if(temp.startsWith("+")){
            temp= temp.substring(1);
        }
        return temp;
    }

    public static boolean isNumber(String temp){
        Pattern pattern = Pattern.compile("^(\\-|\\+)?\\d+(\\.\\d+)?$");
        Matcher matcher = pattern.matcher(temp);
        return matcher.matches();
    }

    public static String removeAntiNumber(String temp){
        if(temp.startsWith("+") || temp.startsWith("-")){
            temp= temp.substring(1);
        }
        int index=0;
        char[] chars = temp.toCharArray();
        for(;index<chars.length;index++){
            if(!Character.isDigit(chars[index])){
                break;
            }
        }
        if(index != chars.length){
            return temp.substring(0,index);
        }else {
            return temp;
        }
    }
}
