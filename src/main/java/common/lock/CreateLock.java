package common.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;


 /**
 * 设计一把自定义的锁
 * 1. 排它锁，只要线程name以"like-lyt"开头的才能获取到锁
 * 2. 不支持重入
 * 3. 支持尝试加锁
 * 4. 支持超时尝试加锁
 * 5. 支持可中断锁
 * 6. 支持wait notify功能
 * 7. 不以"like-lyt"开头的线程名称拒绝
 */
public class CreateLock implements Lock {
    /**
     * steps:
     * 1. implements Lock
     * 2. 写一个静态的内部类，extends AbstractQueuedSynchronizer
     * 3. 重写AQS里面的方法：只有5个方法可以被重写。
     * 4. 如果想要写一个排他锁，只需要使用两个方法就可以了
     *
     *  1. Lock具有搞扩展性。它是通过实现Lock以及内部类继承AQS进行自我的代码的重写，所有的逻辑都自己把控
     *  2. 随着需求的增加，里面的代码量增加
     */


    private static class Sync extends AbstractQueuedSynchronizer {
        // 排它锁的实现
        protected boolean tryAcquire(int arg){
            if(!Thread.currentThread().getName().startsWith("like-lyt")){
                return false;
            }
            if(compareAndSetState(0,arg)){
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }
        // 排它锁的实现
        protected boolean tryRelease(int arg){
            // 能够解锁，说明本身就持有锁
            if(getState() == 0){
                // 没有锁不需要解锁
                throw new IllegalMonitorStateException();
            }
            setState(0);
            setExclusiveOwnerThread(null);
            return true;
        }
        // 剩下的三个方法
        // 共享锁的实现
//        protected int tryAcquireShared(int arg) {
//            throw new UnsupportedOperationException();
//        }
        // 共享锁的实现
//        protected boolean tryReleaseShared(int arg) {
//            throw new UnsupportedOperationException();
//        }
        // 看线程执行拥有情况
//        protected boolean isHeldExclusively() {
//            throw new UnsupportedOperationException();
//        }
        Condition getCondition(){
            return new ConditionObject();
        }

    }
    private Sync sync = new Sync();
    @Override
    public void lock() {
        sync.acquire(1);
    }
    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1,unit.toNanos(time));
    }
    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return sync.getCondition();
    }


}
