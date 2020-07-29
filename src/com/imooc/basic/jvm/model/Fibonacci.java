package com.imooc.basic.jvm.model;

//斐波那契函数
public class Fibonacci {
    //F(0)= 0,F(1)=1,当n > 2是,F(n) = F(n-1) + F(n-2)
    //F(2) = F(1) + F(0) = 1,F(3) = F(2) + F(1) = 2

    public static int f(int n){
        if (n == 0) {
           return 0;
        }
        if (n == 1) {
            return 1;
        }
        return f(n-1) + f(n-2);
    }

    public static void main(String[] args) {
        System.out.println(f(0));
        System.out.println(f(1));
        System.out.println(f(2));
        System.out.println(f(9));


    }

}
