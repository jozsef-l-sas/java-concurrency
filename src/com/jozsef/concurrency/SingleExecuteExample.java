package com.jozsef.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleExecuteExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        List<Callable<Integer>> callables = new ArrayList<>();
        callables.add(() -> 1);
        callables.add(() -> 2);

        try {
            System.out.println("Result: " + executorService.invokeAll(callables));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }
}
