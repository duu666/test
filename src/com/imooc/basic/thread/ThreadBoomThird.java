package com.imooc.basic.thread;

public class ThreadBoomThird implements Runnable {
    @Override
    public void run() {
        try {
            while (true) {
                int i = 0;
                while (i < 3) {
                    i++;
                    System.out.println("波动拳第"+i+"发");
                    Thread.sleep(1000);
                }
                System.out.println("开始5秒充能");
                Thread.sleep(5000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
