package test_alex;

import java.util.Random;
import java.util.concurrent.Semaphore;

class Log{
    public static void println(String s){
        System.out.println(Thread.currentThread().getName()+": "+s);
    }
}
class BoundedResource{
    private final java.util.concurrent.Semaphore semaphore;
    private final int permits;
    private final static Random random = new Random(314159);
    //构造函数(permits为资源个数)
    public BoundedResource(int permits){
        this.semaphore = new java.util.concurrent.Semaphore(permits);
        this.permits = permits;
    }

    //使用资源
    public void use()throws InterruptedException{
        semaphore.acquire();
        try{
            doUse();
        }finally {
            semaphore.release();
        }
    }

    //实际使用资源(此处仅使用Thead.sleap)
    protected void doUse() throws InterruptedException{
        Log.println("BEGIN: used = "+(permits - semaphore.availablePermits()));
        Thread.sleep(random.nextInt(500));
        Log.println("END: used = "+(permits - semaphore.availablePermits()));
    }

}
//使用资源的线程
 class UserThread extends Thread{
    private final static Random random = new Random(26535);
    private final BoundedResource resource;
    public UserThread(BoundedResource resource){
        this.resource = resource;
    }
    public void run(){
        try{
            resource.use();
            Thread.sleep(random.nextInt(3000));
        }catch (InterruptedException e){

        }
    }
}

public class SemaphoreTest {
    public static void main(String[] args) {
        //设置三个资源
        BoundedResource resource = new BoundedResource(3);
        //使用是个线程使用资源
        for(int i = 0;i< 10;i++){
            new UserThread(resource).start();
        }
    }
}
