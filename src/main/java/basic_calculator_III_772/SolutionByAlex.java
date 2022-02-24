package basic_calculator_III_772;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SolutionByAlex {

    // 计算器1：表达式只要数字和加法符号
    int calculate1(String s){
        // 将字符串的字符放入队列中
        Queue<Character> queue = new LinkedList<>();
        for(char c:s.toCharArray()){
            // 如果输入允许空格
            // 可以加上 c!=''的过滤条件
            queue.offer(c);
        }
        // 最后追加一个+，让最后一个数字也能处理
        queue.add('+');
        // num表示当前的数字，sum表示最后的总和
        int num=0,sum =0;
        // 遍历队列，从队列中逐个取出字符
        while(!queue.isEmpty()){
            char c = queue.poll();
            // 如果当前字符是数字，则更新num变量
            if(Character.isDigit(c)){
                num = 10* num +c-'0';
            }else {
                // 如果遇到加号，则把当前num加入到sum中，并把num清零
                sum += num;
                num =0;
            }
        }
        // 由于字符串最后没有加号，所以最后还要再一次将num加入sum中,可在queue最后人工加一个+号
         //        sum += num;
        // 返回结果
        return sum;
    }

    // 计算器2：加入减法
    int calculate2(String s){
        // 将字符串的字符放入队列中
        Queue<Character> queue = new LinkedList<>();
        for(char c:s.toCharArray()){
            if (c != ' ') {
                queue.offer(c);
            }
        }
        queue.add('+');
        // 添加一个符号变量,用来记录当前数字时正数还是负数，初始化为正数
        char sign = '+';
        int num = 0,sum =0;
        while(!queue.isEmpty()){
            char c = queue.poll();
            if(Character.isDigit(c)){
              num = 10 * num + c-'0';
            }else {
                // 遇到符号，说明我们要统计一下当前的结果
                if(sign == '+'){
                    // 如果当前数字的符号是加号，即正数，直接加入至总和
                    sum += num;
                }else if(sign == '-'){
                    // 如果当前数字的符号是减号，即负数
                    // 从总和中减去该数
                    sum -= num;
                }
                // 最后更新一下当前符号位，并将num清零
                num = 0;
                sign = c;
            }
        }
        return sum;
    }



    // 计算器3：加入乘法和除法
    int calculate3(String s){
        // 将字符串的字符放入队列中
        Queue<Character> queue = new LinkedList<>();
        for(char c:s.toCharArray()){
            if (c != ' ') {
                queue.offer(c);
            }
        }
        queue.add('+');
        // 添加一个符号变量,用来记录当前数字时正数还是负数，初始化为正数
        char sign = '+';
        int num = 0;
        // 定义stack用来记录要被处理的数
        Stack<Integer> stack = new Stack<>();

        while(!queue.isEmpty()){
            char c = queue.poll();
            if(Character.isDigit(c)){
                num = 10 * num + c-'0';
            }else {
                // 遇到符号，说明我们要统计一下当前的结果
                if(sign == '+'){
                    // 当遇到的是加号，把当前的数压入堆栈中
                   stack.push(num);
                }else if(sign == '-'){
                    // 当遇到的是减号，把当前的数的相反数压入堆栈中
                  stack.push(-num);
                }else if(sign == '*'){
                    // 当遇到的是乘号，把前一个数从堆栈中取出，然后和当前的数相乘，相乘完毕之后再放回堆栈
                    stack.push(stack.pop()*num);
                }else if(sign == '/'){
                    // 当遇到的是除号，把前后一个数从堆栈中取出，然后和当前的数相除，相除完毕之后在放回堆栈
                    stack.push(stack.pop()/num);
                }
                // 最后更新一下当前符号位，并将num清零
                num = 0;
                sign = c;
            }
        }
        int sum=0;
        // 堆栈里存储的都是需要相加的结果
        // 将他们相加返回总和即可
        while(!stack.isEmpty()){
            sum += stack.pop();
        }
        return sum;
    }


    // 计算器3：加入小括号
    int calculate4(String s){
        // 将字符串的字符放入队列中
        Queue<Character> queue = new LinkedList<>();
        for(char c:s.toCharArray()){
            if (c != ' ') {
                queue.offer(c);
            }
        }
        queue.add('+');
        return calculate(queue);
    }
    int calculate(Queue<Character> queue){
        // 添加一个符号变量,用来记录当前数字时正数还是负数，初始化为正数
        char sign = '+';
        int num = 0;
        // 定义stack用来记录要被处理的数
        Stack<Integer> stack = new Stack<>();
        while(!queue.isEmpty()){
            char c = queue.poll();
            if(Character.isDigit(c)){
                num = 10 * num + c-'0';

            }else if(c=='('){
                // 当遇到一个左括号，开始递归地调用，
                // 求得括号中的计算结果，将它赋值给当前的num
                num = calculate(queue);
            }
            else {
                // 遇到符号，说明我们要统计一下当前的结果
                if(sign == '+'){
                    // 当遇到的是加号，把当前的数压入堆栈中
                    stack.push(num);
                }else if(sign == '-'){
                    // 当遇到的是减号，把当前的数的相反数压入堆栈中
                    stack.push(-num);
                }else if(sign == '*'){
                    // 当遇到的是乘号，把前一个数从堆栈中取出，然后和当前的数相乘，相乘完毕之后再放回堆栈
                    stack.push(stack.pop()*num);
                }else if(sign == '/'){
                    // 当遇到的是除号，把前后一个数从堆栈中取出，然后和当前的数相除，相除完毕之后在放回堆栈
                    stack.push(stack.pop()/num);
                }
                // 最后更新一下当前符号位，并将num清零
                num = 0;
                sign = c;
                // 当遇到一个右括号，就可以结束循环，直接返回当前总和
                if(c == ')'){
                    break;
                }
            }
        }
        int sum=0;
        // 堆栈里存储的都是需要相加的结果
        // 将他们相加返回总和即可
        while(!stack.isEmpty()){
            sum += stack.pop();
        }
        return sum;

    }


}
