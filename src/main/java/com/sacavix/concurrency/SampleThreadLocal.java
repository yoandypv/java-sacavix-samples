package com.sacavix.concurrency;

public class SampleThreadLocal {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {

        threadLocal.set("Main Thread Value");

        new Thread(() -> {
            System.out.println("Child Thread: " + threadLocal.get());
        }).start();

        System.out.println("Main Thread: " + threadLocal.get());
    }

}