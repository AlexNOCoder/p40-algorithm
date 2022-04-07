package common.utils;

/**
 * @author luoyuntian
 * @program: p40-algorithm
 * @description: 打印递归调用栈，方便调试
 * @date 2022-04-08 07:25:20
 */
public class PrintStackUtil {
    // 全局变量，记录递归函数的递归层数
    public static int count = 0;

    // 输入n,打印n个tab缩进
    public static void printIndent(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("  ");
        }
    }
    public static int fib(int n){
        printIndent(count++);
        System.out.println(String.format("n = %d",n));
        if(n == 1 || n==2){
            printIndent(--count);
            System.out.println("return 1");
            return 1;
        }
        int fn1 = fib(n-1);
        int fn2 = fib(n-2);

        printIndent(--count);
        System.out.println(String.format("return %d",fn1+fn2));
        return fn1+fn2;
    }

    public static void main(String[] args) {
        fib(7);

    }

}
