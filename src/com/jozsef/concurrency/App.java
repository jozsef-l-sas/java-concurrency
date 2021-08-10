package com.jozsef.concurrency;

public class App {

    public static void main(String[] args) {
        Thread t = new CustomThread();

        Thread tCallable = new Thread(new RunThread());
        Thread tCallable2 = new Thread(new RunThread());

        Thread tLambdaCallable = new Thread(() -> System.out.println("Thread with callable: " + Thread.currentThread().getId()));

        System.out.println("Main: " + Thread.currentThread().getId());

        t.start();
        t.run();

        tLambdaCallable.start();

        tCallable.start();

        try {
            tCallable.join(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tCallable2.start();
    }

}
