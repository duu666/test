package com.imooc.basic.thread;

import java.util.Map;
import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        String value = "test";
        System.out.println("ready to work");
        Thread.sleep(3000);
        System.out.println("task to done");
        return value;
    }
}
