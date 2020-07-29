package com.imooc.basic.juc;

import java.util.concurrent.*;

public class ExchangerDemo {
    public static Exchanger<String> exchanger = new Exchanger<>();

    public static void main(String[] args) {
        //代表男生和女生
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.execute(new Runnable() {
            @Override
            public void run() {
                try{
                    //女生对男生说的话
                    String girl = exchanger.exchange("我其实暗恋你很久了......");
                    System.out.println("女生说："+girl);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        service.execute(new Runnable() {
            @Override
            public void run() {
                try{
                    System.out.println("女生慢慢从教室走出来......");
                    TimeUnit.SECONDS.sleep(3);
                    //男生对女生说的话
                    String boy = exchanger.exchange("我很喜欢你......");
                    System.out.println("男生说："+boy);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
    }
}
