package com.imooc.basic.thread;

public class CycleWait implements Runnable {

    private String value;

    @Override
    public void run() {
        try{
            Thread.sleep(5000);
        }catch (Exception e) {
            e.printStackTrace();
        }
        value = " we have data";
    }

    public static void main(String[] args) throws InterruptedException {
        CycleWait cycleWait = new CycleWait();
        Thread t = new Thread(cycleWait);
        t.start();
        while (cycleWait.value == null) {
            Thread.sleep(100);
        }
        t.join();
        System.out.println("the value:" + cycleWait.value);
    }
}
