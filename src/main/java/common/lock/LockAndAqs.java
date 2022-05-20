package common.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author luoyuntian
 */
public class LockAndAqs {
    static CreateLock lock = new CreateLock();
    static ReentrantLock reentrantLock = new ReentrantLock();
    public static void main(String[] args) {
        Thread a = new Thread( () -> {
            testLock();
            while (true){

            }
        });
        Thread b = new Thread( () -> {
            testLock();
        });
        a.setName("like-1lyt-11");
        b.setName("like-alex-11");
        a.start();
        b.start();
    }

    public static void testLock(){
        lock.lock();
        try{
            System.out.println("获取到锁："+Thread.currentThread().getName());
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }


}
