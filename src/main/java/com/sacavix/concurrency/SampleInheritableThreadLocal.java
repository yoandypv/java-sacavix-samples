package com.sacavix.concurrency;

public class SampleInheritableThreadLocal {

    private static InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) {

        inheritableThreadLocal.set("Main Thread Value");

        new Thread(() -> {
            System.out.println("Child Thread: " + inheritableThreadLocal.get());
        }).start();

        System.out.println("Main Thread: " + inheritableThreadLocal.get());
    }
}
