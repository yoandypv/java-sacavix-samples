package com.sacavix.concurrency.virtualthreads.pinned;

public class PinnedSynchronized {

    public static void main(String[] args) throws InterruptedException {

        final CounterWithSynchronized counter = new CounterWithSynchronized();

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

class CounterWithSynchronized {

    private int count = 0;

    public void increment() {
        synchronized (this) {
            try {
                Thread.sleep(100); // This simulates a blocking call within the synchronized block
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
        }
    }

    public synchronized int getCount() {
        return count;
    }
}

