package jewels_and_stones_771;

import java.util.List;

public class SolutionByAlex {

    public static int numJewelsInStones(String J, String S) {
        int count =0;
        for(int i=0;i<S.length();i++){
            for(int j=0;j<J.length();j++){
               if(S.charAt(i) == J.charAt(j)){
                   count++;
               }
            }
        }
        return count;
    }

    public static void main(String[] args) {
       String  J = "aA", S = "aAAbbbb";
        System.out.println(numJewelsInStones(J,S));
    }
}


