package is_palindrome_9;

/**
 * @program: p40-algorithm
 * @description: 回文数
 * @author: lijie
 * @create: 2020-06-30 16:53
 */
public class SolutionByJack {
    public boolean isPalindrome(int x){
        if (x < 0 || (x % 10 == 0 && x != 0)){
            return false;
        }
        int revertedNumber = 0;
        while(x > revertedNumber){
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber / 10;
    }
}
