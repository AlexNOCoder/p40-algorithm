package common.utils;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * @author luoyuntian
 * @program: p40-algorithm
 * @description: 线程池监控
 * @date 2022-03-09 15:31:29
 */
public class ThreadPoolMonitor {
    public static void printThreadPollStats(ThreadPoolExecutor threadPool){
        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(
                () -> {
                    System.out.println("========================");
                    System.out.println(String.format("Poll Size: %d",threadPool.getPoolSize()));
                    System.out.println(String.format("Active Threads: %d",threadPool.getActiveCount()));
                    System.out.println(String.format("Number of Tasks Completed: %d",threadPool.getCompletedTaskCount()));
                    System.out.println(String.format("Number of Tasks in Queue: %d", threadPool.getQueue().size()));
                }
        ,0,1, TimeUnit.SECONDS);
    }

    public static void main(String[] args) throws Exception {
        // 创建计数器
        AtomicInteger atomicInteger = new AtomicInteger();
        // 创建一个具有2个核心线程，5个最大线程，使用容量为10的ArrayBlockingQueue阻塞队列作为测试

        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                2,5,5,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10),
                new ThreadFactoryBuilder().setNameFormat("demo-threadpool-%d").build(),
                new ThreadPoolExecutor.AbortPolicy());

        printThreadPollStats(threadPool);
        // 每隔一秒钟提交一次，一共提交20次
        IntStream.rangeClosed(1,50).forEach(
                i ->{
                    try{
                        TimeUnit.SECONDS.sleep(1);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    int id = atomicInteger.incrementAndGet();
                    try {
                        threadPool.submit(
                                () ->{
                                    System.out.println(String.format("%s %d start",Thread.currentThread().getName(),id));
                                    try{
                                        TimeUnit.SECONDS.sleep(10);
                                    }catch (InterruptedException e){

                                    }
                                    System.out.println(String.format("%s %d finished",Thread.currentThread().getName(),id));
                                }
                        );
                    }catch(Exception e){
                        //提交出现异常，打印错误日志并计数器减一
                        System.out.println(String.format("error submitt task %s %d",Thread.currentThread().getName(),id));
                    }
                }
        );
        
        TimeUnit.SECONDS.sleep(60);
        System.out.println("*** result："+ atomicInteger.intValue());
    }
}
