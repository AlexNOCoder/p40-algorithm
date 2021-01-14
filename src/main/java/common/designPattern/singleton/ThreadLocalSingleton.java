package common.designPattern.singleton;

import java.util.concurrent.Executor;

public class ThreadLocalSingleton {
    //ThreadLocal不能保证其创建的对象时全局唯一的，但是能保证在单个线程中时唯一的，天生的线程安全

    private static final ThreadLocal<ThreadLocalSingleton> threadLocalInstance = new ThreadLocal<ThreadLocalSingleton>(){
        @Override
                protected ThreadLocalSingleton initialValue(){
            return new ThreadLocalSingleton();
               }
            };

    private ThreadLocalSingleton(){};

    public static ThreadLocalSingleton getInstance(){
        return threadLocalInstance.get();
    }


    public static void main(String[] args) {
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        Thread t1 = new Thread(new ExecutorThread());

        Thread t2 = new Thread(new ExecutorThread());

        t1.start();
        t2.start();
        System.out.println("end");

    }


    private static class ExecutorThread implements Runnable{
        @Override
        public void run() {
            System.out.println(ThreadLocalSingleton.getInstance());
        }
    }
}
