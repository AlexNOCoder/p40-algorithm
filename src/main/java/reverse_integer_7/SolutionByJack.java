package reverse_integer_7;

/**
 * @program: p40-algorithm
 * @description: 整数反转
 * @author: lijie
 * @create: 2020-06-30 14:23
 */
public class SolutionByJack {
    public int reverse(int x){
        int rev = 0;
        while(x != 0){
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE/10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE/10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
