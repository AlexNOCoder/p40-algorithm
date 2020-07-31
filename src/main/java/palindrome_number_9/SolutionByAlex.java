package palindrome_number_9;

public class SolutionByAlex {
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        if(0 <= x  && x<10){
            return  true;
        }
        char[] number = (""+x).toCharArray();

        for(int i=0,j=number.length-1;i<=j;i++,j--){
            if(number[i] != number[j]){
                return false;
            }
        }

        return true;
    }
}
