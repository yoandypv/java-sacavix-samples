package com.sacavix.concurrency.SampleInheritableWithExecutor;

import java.util.concurrent.*;
import java.util.function.Supplier;

public class SampleWithExecutorService {

    public static Integer doSomething(int id) {
        System.out.println("Doing something id=" + id + " ... " + AppContext.get().getValue());
        return id;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService ex =  new ThreadPoolExecutor(8, 16, 1000,
                TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());

        for (int i = 0; i < 10; i++) {
            AppContext.set(new AppInfo(i));
            final int finalI = i;
            Supplier<Integer> supplier = () -> doSomething(finalI);
            CompletableFuture<Integer> result = CompletableFuture.supplyAsync(supplier, ex);
            System.out.println(result.get());
            AppContext.remove();

        }

       ex.shutdown();
    }

}
