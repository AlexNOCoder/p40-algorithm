package common.buffer;

import java.util.concurrent.TimeUnit;

/**
 * @author luoyuntian
 * @program: p40-algorithm
 * @description: 消费者
 * @date 2022-05-05 17:54:55
 */
public class Consumer {
    public void consumeMessage(){
        boolean isRunning = true;
        while(isRunning){
            try{
                String msg = BlockingQueueMessage.queue.poll(2, TimeUnit.SECONDS);
                if(null != msg){
                    System.out.println("接收到的消息： "+msg);
                }else{
                    isRunning = false;
                }
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
