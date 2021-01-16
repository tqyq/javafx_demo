package com.altman.demo.thread;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class CoreTest {

    public static void main(String[] args) throws Exception {
        var threads = new ArrayList<Thread>();
        long st = System.currentTimeMillis();
//        final int max_locks = Runtime.getRuntime().availableProcessors() + 1;
        final int max_locks = 2;
        ReentrantLock[] locks = new ReentrantLock[max_locks];
        for (var i = 0; i < max_locks; i++) {
            locks[i] = new ReentrantLock();
        }
        for (int j = 0; j < 10; j++) {
            int n = j;
            threads.add(new Thread(() -> {
                try {
                    ReentrantLock lock = locks[n % max_locks];
                    lock.lock();
                    Thread.sleep(1000);
                    lock.unlock();
                    System.out.println(n + " cost " + (System.currentTimeMillis() - st));
                } catch (Exception e) {
                }
            }));
        }
        for (var t : threads) t.start();
        for (var t : threads) t.join();
    }

}
