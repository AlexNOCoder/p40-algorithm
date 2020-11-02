package find_common_characters_1002;


import java.util.ArrayList;
import java.util.List;

public class SolutionByAlex {
    public static List<String> commonChars(String[] A) {
        if(A == null){
            return  null;
        }
        //处理只有一个字符串的情况，此时只需要将这个字符串拆分以后返回
        List<String> result = new ArrayList<>();
        if(A.length == 1){
            for(String str:A){
                result.add(str);
            }
            return result;
        }
        //处理大于1个字符串的情况
        //对于已经匹配了的字符应该从原来字符串中抹去，可以用一个标志数组来记录
        //初始化标志数组,每一个字符串对应一个数组
        List<Integer[]> flags = new ArrayList<>();
        for(String str:A){
            Integer[] flag = new Integer[str.length()];
            flags.add(flag);
        }
        String first = A[0];
        for(int i=0;i<first.length();i++){
            boolean flag = true;
            for(String str:A){
                if(!str.contains(String.valueOf(first.charAt(i)))){
                    flag = false;
                }
            }
            if(flag){
                result.add(String.valueOf(first.charAt(i)));
            }

        }

        return result;
    }








    public static void main(String[] args) {
//        String[] A = {"bella","label","roller"};
        String[] B = {"cool","lock","cook"};
//        List<String> resultA = commonChars(A);
        List<String> resultB = commonChars(B);
//        System.out.println(resultA.toString());
        System.out.println(resultB.toString());
    }
}


