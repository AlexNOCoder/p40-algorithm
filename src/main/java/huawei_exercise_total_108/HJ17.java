package huawei_exercise_total_108;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HJ17 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String input = sc.nextLine();
            String[] inputArr = input.split(";");
            List<String> list = new ArrayList<>();
            for(String str:inputArr){
                if(str != "" && isReg(str)){
                    list.add(str);
                }
            }
            int x=0;
            int y=0;
            for(String str:list){
                String operation  = str.substring(0,1);
                switch (operation){
                    case "A":
                        x -= Integer.valueOf(str.substring(1));
                        break;
                    case "S":
                        y -= Integer.valueOf(str.substring(1));
                        break;
                    case "W":
                        y += Integer.valueOf(str.substring(1));
                        break;
                    case "D":
                        x += Integer.valueOf(str.substring(1));
                        break;
                }
            }
            System.out.println(x+","+y);
        }
    }

    public static boolean isReg(String str){
        Pattern pattern = Pattern.compile("^[AWSD](\\d{1,2})$");
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

}
