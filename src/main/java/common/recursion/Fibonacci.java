package common.recursion;

import java.io.Serializable;

/**
 * @description 通过尾递归来优化斐波那契计算
 */
public class Fibonacci implements Serializable {



    //普通递归
    public static long fibonacci(long index){
        if(index <= 1){
            return index;
        }else {
            System.out.println("fibonacci"+"("+(index -1)+")"+"+"+"fibonacci"+"("+(index -2)+")");
            return fibonacci(index - 1) + fibonacci(index - 2);
        }
    }

    //尾递归
    public static long fibonacciTailRecursion(long index){
        return fibonacciTailRecursion(index,0,1);
    }
    public static long fibonacciTailRecursion(long index,int curr,int next){
        if(index == 0){
            return curr;
        }else {
            System.out.println("fibonacciTailRecursion("+(index -1)+","+next+","+(curr+next)+")");
            return fibonacciTailRecursion(index -1,next,curr + next);
        }
    }

    public static void main(String[] args) {
        System.out.println("值为："+fibonacci(20));
        System.out.println("=============");
        System.out.println("值为："+fibonacciTailRecursion(20));
    }
}
