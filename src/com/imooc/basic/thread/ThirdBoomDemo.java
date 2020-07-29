package com.imooc.basic.thread;

public class ThirdBoomDemo {

    public static void main(String[] args) {

        ThreadBoomThird tbt = new ThreadBoomThird();
        new Thread(tbt).start();
    }
}
