package com.imooc.basic.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectSample {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class cl = Class.forName("com.imooc.basic.reflect.Robo");
        Robo robo = (Robo) cl.newInstance();
        //getDeclaredMethod只能获取实例中被声明的方法，私有方法和共有方法，不能获取实现接口的方法以及集成方法
        Method throwMessage = cl.getDeclaredMethod("throwMessage", String.class);
        throwMessage.setAccessible(true);       //私有化一定要设置成true
        Object str = throwMessage.invoke(robo,"the world");
        System.out.println(" get the result :" + str);
        //只能获取实例中所有public方法，不能获取到private方法，也能获取实现接口的方法和集成类中的方法
        Method sayHi = cl.getMethod("sayHi", String.class);
        sayHi.invoke(robo,"is me");
        //获取变量
        Field field = cl.getDeclaredField("name");
        field.setAccessible(true);
        field.set(robo,"Alice");
        sayHi.invoke(robo,"is me");
    }
}
