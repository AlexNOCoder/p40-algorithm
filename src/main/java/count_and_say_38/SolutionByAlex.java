package count_and_say_38;

public class SolutionByAlex {

    public static String countAndSay(int n) {

        String[] dp = new String[n];
        dp[0] = "1";
        for(int i=1;i<dp.length;i++){
            dp[i] = sayPreNumber(dp[i-1]);
        }
        return dp[n-1];
    }

    //对前一个数字进行描述
    public static String sayPreNumber(String preNumber){
        char[] preNumberChars = preNumber.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        int times = 1;
        for(int i=0,j=0;j<preNumberChars.length;){

            if(j+1 < preNumberChars.length && preNumberChars[j] == preNumberChars[j+1]){
                j++;
                times++;
            }else {
                stringBuilder.append(times);
                stringBuilder.append(preNumberChars[i]);
                //后移,重新开始计数
                times = 1;
                j++;
                i=j;
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {

        System.out.println(countAndSay(4));
//        System.out.println(sayPreNumber("1"));
//        System.out.println(sayPreNumber("11"));
//        System.out.println(sayPreNumber("21"));

    }
}


