package common.utils;

import java.util.concurrent.TimeUnit;

/**
 * @author luoyuntian
 * @program: p40-algorithm
 * @description: test
 * @date 2022-04-04 19:47:59
 */
public class ThreadTest extends Thread {
    public void run() {
        System.out.println("In run");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        yield();
        System.out.println("Leaving run");
    }
    public static void main(String []argv) {
        (new ThreadTest()).start();
    }
}
