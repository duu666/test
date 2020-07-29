package com.imooc.basic.thread;

public class WaitSleepDemo {

    public static void main(String[] args) {
        final Object lock = new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread A is waiting to get lock");
                synchronized (lock) {
                    System.out.println("thread A get lock");
                    try {
                        Thread.sleep(20);
                        System.out.println("thread A do wait");
                        lock.wait();
                        System.out.println(" thread A is done");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread B is waiting to get lock");
                synchronized (lock) {
                    System.out.println("thread B get lock");
                    System.out.println("thread B is sleeping 10ms");
                    try {
                        Thread.sleep(10);
                        System.out.println("thread B is done");
                        //lock.notify();
                        lock.notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
