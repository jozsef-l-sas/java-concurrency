package com.jozsef.concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ScheduledPoolExample {
    private static ScheduledExecutorService executorService = Executors.newScheduledThreadPool(50);

    private static void schedule() {
        ScheduledFuture<Double> doubleFuture = executorService.schedule(() -> {
            Thread.sleep((long) (Math.random() * 200));
            System.out.println(1 + " Thread id: " + Thread.currentThread().getId());
            return Math.random();
        }, 1000, TimeUnit.MILLISECONDS);

        try {
            System.out.println(doubleFuture.get(100, TimeUnit.MILLISECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
            doubleFuture.cancel(true);
        }

        if (doubleFuture.isCancelled()) {
            System.out.println("Very sorry, but the future was cancelled.");
        }

        if (doubleFuture.isDone()) {
            System.out.println("I'm done!");
        }

        executorService.shutdown();
    }

    private static void scheduleWithFixedDelay() {
        int i = 0;
        executorService.scheduleWithFixedDelay(() -> System.out.println(i + " Thread id: " + Thread.currentThread().getId()), 1000, 500, TimeUnit.MILLISECONDS);
        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void scheduleAtFixedRate() {
        int i = 0;
        executorService.scheduleAtFixedRate(() -> {
            System.out.println(i + " Thread id: " + Thread.currentThread().getId());
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 2000, 100, TimeUnit.MILLISECONDS);
        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        schedule();
//        scheduleWithFixedDelay();
        scheduleAtFixedRate();
    }
}
