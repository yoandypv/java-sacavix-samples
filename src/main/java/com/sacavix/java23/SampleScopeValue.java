package com.sacavix.java23;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SampleScopeValue {

    private static final ScopedValue<String> scopedValue = ScopedValue.newInstance();

    // JEP 481 - Scoped Values
    public static void main(String[] args) {

            ExecutorService executor = Executors.newFixedThreadPool(2);

            Runnable task = () -> ScopedValue.where(scopedValue, "Value in " + Thread.currentThread().getName())
                    .run(() -> {
                System.out.println(Thread.currentThread().getName() + " initial value: " + scopedValue.get());

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted while waiting for value");
                }
                System.out.println(Thread.currentThread().getName() + " final value: " + scopedValue.get());
            });

            executor.submit(task);
            executor.submit(task);
            executor.shutdown();
        }

}
