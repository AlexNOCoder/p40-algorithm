package zigzag_conversion_6;

import java.util.ArrayList;
import java.util.List;

public class SolutionByAlex {
    public static void main(String[] args) {
        System.out.println(convert("AB",2));
    }
    public static String convert(String s, int numRows) {
        //针对只有一行输出的情况
        if(numRows<2){
            return s;
        }
        char[] inputChars = s.toCharArray();
        List<List<String>> lists = new ArrayList<>();
        //遍历顺序正逆的开关
        int flag =1;
        for(int i=0;i<numRows;i++){
            List<String> temp = new ArrayList<>();
            lists.add(temp);
        }
        int m=0;
        for(int k=0;k<s.length();k++){
            if(flag ==1){
                //正序
                List<String> tempList = lists.get(m);
                tempList.add(String.valueOf(inputChars[k]));
                m++;
            }else{
                //逆序
                List<String> tempList = lists.get(m);
                tempList.add(String.valueOf(inputChars[k]));
                m--;
            }
            if(m >=numRows){
                m = numRows-1-1;
                flag = flag * (-1);
            }
            if(m < 0){
                m = 0+1;
                flag = flag * (-1);
            }
        }
        StringBuffer sb = new StringBuffer();
        for(List<String> list:lists){
            for(String str:list){
                sb.append(str);
            }
        }
        return sb.toString();
    }
}
