package grumpy_bookstore_owner_1052;


public class SolutionByAlex {

    public static int maxSatisfied(int[] customers, int[] grumpy, int X) {
        //窗口滑动实现x窗口内负数最小
        int n = customers.length;
        int sum = 0;
        int minuSum =0;
        int maxMinus = 0;
        for(int i=0;i<n;i++){
            sum += customers[i];

            if(grumpy[i] == 1){
                minuSum += customers[i];
                System.out.print("-"+customers[i]);
            }else {
                System.out.print(customers[i]);
            }
            System.out.print(" ");
        }
        System.out.println(" ");
        if(n<=X){
            //处理时间不大于X的情况

            return sum;
        }
        int i=0;
        for(;i+X<=n;i++){
            System.out.println("i:"+i+" num:"+customers[i]);
            int tempMinus =0;
            for(int k=0;k<X;k++){
                if(grumpy[i+k] == 1){
                    //为负数
                    tempMinus -= customers[i+k];
                }
            }
            System.out.println(tempMinus);
            maxMinus = Math.min(maxMinus,tempMinus);
        }

        return sum - minuSum - maxMinus;
    }

    public static void main(String[] args) {
        int[] customers = {1,0,1,2,1,1,7,5};
        int[] grumpy = {0,1,0,1,0,1,0,1};
        int X = 3;
        System.out.println(maxSatisfied(customers,grumpy,X));
    }
}
