package com.sacavix.concurrency.virtualthreads.pinned;

import java.util.concurrent.locks.ReentrantLock;

public class PinnedLocks {

    public static void main(String[] args) throws InterruptedException {

        final CounterWithLock counter = new CounterWithLock();

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        };

        Thread thread1 = Thread.ofVirtual().start(task);
        Thread thread2 = Thread.ofVirtual().start(task);

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("Error: " + e);
        }

        System.out.println("Final counter value: " + counter.getCount());
    }
}

class CounterWithLock {

    private int count = 0;
    private final ReentrantLock lock = new ReentrantLock();

    public void increment() {
        lock.lock();
        try {
            Thread.sleep(100); // This simulates a blocking call
            count++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public synchronized int getCount() {
        return count;
    }
}
