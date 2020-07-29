package com.imooc.basic.reflect;

public class Robo {

    private String name;

    public void sayHi(String message){
        System.out.println(name + " " + message);
    }

    private String throwMessage(String message){
        return "get the message" + message;
    }
}
