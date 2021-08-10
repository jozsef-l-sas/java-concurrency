package com.jozsef.concurrency;

/**
 * Thread interference demo.
 */
public class CountSynchronized {
    public static int counter = 0;
    public static Object lock = new Object();

    public synchronized static void incrementCounter() {
        int current = counter;
        System.out.println("Before: " + counter + ", Current thread: " + Thread.currentThread().getId());
        counter++;
        System.out.println("After: " + counter + ", Current thread: " + Thread.currentThread().getId());
    }

    public static void incrementCounterLock() {
        synchronized (lock) {
            int current = counter;
            System.out.println("Before: " + counter + ", Current thread: " + Thread.currentThread().getId());
            counter = current + 1;
            System.out.println("After: " + counter + ", Current thread: " + Thread.currentThread().getId());
        }
    }

    public static void main(String[] args) {
        for (int i=0; i<10; i++) {
            Thread t = new Thread(() -> incrementCounterLock());
            t.start();
        }
    }
}
