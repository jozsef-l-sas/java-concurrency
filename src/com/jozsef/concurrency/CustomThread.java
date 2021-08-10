package com.jozsef.concurrency;

public class CustomThread extends Thread {

    @Override
    public void run() {
        System.out.println("I'm a custom thread!, Runnable: " + Thread.currentThread().getId());
    }
}
