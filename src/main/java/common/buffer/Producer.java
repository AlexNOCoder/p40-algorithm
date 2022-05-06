package common.buffer;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author luoyuntian
 * @program: p40-algorithm
 * @description: 生产者
 * @date 2022-05-05 17:49:53
 */
public class Producer {
    private static AtomicInteger count = new AtomicInteger();


    public void produceMessage1(){
        while(true){
            offer("张三");
        }

    }

    public void produceMessage2(){
        while(true){
            offer("李四");
        }
    }

    public void produceMessage3(){
        while(true){
            offer("王五");
        }
    }
    public void offer(String name){
        try{
            String str = String.valueOf(count.incrementAndGet());
            System.out.println(name+" 生产消息: "+str);
            BlockingQueueMessage.queue.offer(str,2, TimeUnit.SECONDS);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
