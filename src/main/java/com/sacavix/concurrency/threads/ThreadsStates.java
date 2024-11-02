package com.sacavix.concurrency.threads;

import java.util.concurrent.locks.LockSupport;

public class ThreadsStates {

    public static void sleep100ms() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {}
    }

    public static void sampleNew() {
        Thread thread = new Thread(() -> System.out.println("Thread new"));
        System.out.println(thread.getState());
    }

    public static void sampleRunnable() {

        Thread thread = new Thread(() -> {
            while (true) {
               // solo para el ejemplo
            }
        });
        thread.start();
        System.out.println(thread.getState());
    }

    public static synchronized void syncMethod() {
        while (true) {
            // solo para el ejemplo
        }
    }

    public static void sampleBlocking() {
        Thread t1 = new Thread(ThreadsStates::syncMethod);
        Thread t2 = new Thread(ThreadsStates::syncMethod);

        t1.start();
        t2.start();

        sleep100ms();

        System.out.println(t2.getState());
    }

    public static void sampleWaiting() {
        Thread t1 = new Thread(() -> {
            synchronized (ThreadsStates.class) {
                try {
                    ThreadsStates.class.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        t1.start();
        sleep100ms();
        System.out.println(t1.getState());
    }

    public static void sampleTimedWaiting() {
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        t1.start();

        sleep100ms();
        System.out.println(t1.getState());
    }

    public static void sampleTerminated() throws InterruptedException {
        Thread t1 = new Thread(() -> System.out.println("Thread running..."));
        t1.start();
        t1.join();
        System.out.println(t1.getState());
    }

    public static void sampleParked() {
        Thread t = new Thread(() -> {
            System.out.println("Thread running...");
            System.out.println("Parking thread ...");
            System.out.println(Thread.currentThread().getState()); //t status
            LockSupport.park();
            System.out.println("Thread resumed (unpark)");
        });

        t.start();
        sleep100ms();
        System.out.println(t.getState()); // t status parked or waiting
        LockSupport.unpark(t); // unparked
        sleep100ms();
        System.out.println(t.getState()); // t status terminated

    }



    public static void main(String[] args) throws InterruptedException {
        //sampleNew();
        //sampleRunnable();
        //sampleBlocking();
        // sampleWaiting();
        //sampleTimedWaiting();
        // sampleTerminated();
        sampleParked();
    }
}
