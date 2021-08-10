package com.jozsef.concurrency;

import java.util.concurrent.Callable;

public class CallThread implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("Inside thread with callable: " + Thread.currentThread().getId());
        return "CallThread result";
    }
}
