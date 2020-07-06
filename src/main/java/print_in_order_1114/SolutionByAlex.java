package print_in_order_1114;


import java.util.concurrent.atomic.AtomicInteger;

public class SolutionByAlex {


    private AtomicInteger flag = new AtomicInteger(0);
    public SolutionByAlex() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        flag.incrementAndGet();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        while(flag.get() != 1){

        }
        printSecond.run();
        flag.incrementAndGet();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while(flag.get() != 2){

        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
