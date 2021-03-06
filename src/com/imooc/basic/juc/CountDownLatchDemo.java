package com.imooc.basic.juc;

import com.sun.jmx.snmp.tasks.Task;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        new CountDownLatchDemo().go();
    }
    private void go() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        //依次创建3个线程，并启动
        new Thread(new Task(countDownLatch),"thread1").start();
        Thread.sleep(1000);
        new Thread(new Task(countDownLatch),"thread2").start();
        Thread.sleep(1000);
        new Thread(new Task(countDownLatch),"thread3").start();
        countDownLatch.await();
        System.out.println("所有线程已到达，主线程开始执行：" + System.currentTimeMillis());

    }

    class Task implements Runnable{

        private CountDownLatch countDownLatch;

        public Task(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            System.out.println("线程" + Thread.currentThread().getName() + "已到达" +System.currentTimeMillis());
            countDownLatch.countDown();
        }
    }
}
