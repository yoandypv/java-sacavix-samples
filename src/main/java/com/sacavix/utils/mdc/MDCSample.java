package com.sacavix.utils.mdc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MDCSample {

    private static final Logger logger = LoggerFactory.getLogger(MDCSample.class);

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        MDC.put("transactionId", "12345");

        Callable<String> task = wrapWithMdc(() -> {
            logger.info("Ejecutando tarea en hilo.");
            return "Resultado de la tarea";
        });

        Future<String> future = executorService.submit(task);
        logger.info("Resultado: {}", future.get());

        executorService.shutdown();
        MDC.clear();
    }


    private static <T> Callable<T> wrapWithMdc(Callable<T> task) {
        var contextMap = MDC.getCopyOfContextMap();

        return () -> {
            if (contextMap != null) {
                MDC.setContextMap(contextMap);
            }
            try {
                return task.call();
            } finally {
                MDC.clear(); // importante para evitar leaks
            }
        };
    }
}
