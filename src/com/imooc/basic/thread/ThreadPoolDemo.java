package com.imooc.basic.thread;

import java.util.concurrent.*;

public class ThreadPoolDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> future = executorService.submit(new MyCallable());
        byte[] o = new byte[0];
        synchronized(o){
            Object obj = new Object();
            obj.wait();
        }
        if (!future.isDone()) {
            System.out.println("task has not finished,please wait!");
        }
        System.out.println("future get:"+future.get());
    }
}
