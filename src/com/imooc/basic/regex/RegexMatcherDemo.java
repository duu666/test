package com.imooc.basic.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatcherDemo {

    public static void main(String[] args) {
        String test1 = "222Javafdasfa";
        Pattern pattern = Pattern.compile("Java");
        Matcher matcher = pattern.matcher(test1);
        StringBuffer stringBuffer = new StringBuffer();
        matcher.appendReplacement(stringBuffer,"Javaee");
        matcher.appendTail(stringBuffer);
        System.out.println(matcher.toMatchResult());
        System.out.println(pattern.matcher(test1).matches());//返回true
    }

    public  void test1(){
        Pattern p= Pattern.compile("\\d{3,5}" );
        Matcher m=p.matcher("123-34345");
        boolean yesorno=m.matches();

        System.out.println(yesorno);
        System.out.println(m.find());
        System.out.println(m.start());
        System.out.println(m.group());
        System.out.println(m.find());
        System.out.println(m.start());
        System.out.println(m.group());
        // System.out.println(m.find());
        // System.out.println(m.find());
        // System.out.println(m.find());
    }

    public void test2(){
        Pattern p=Pattern.compile("\\d+" );
        Matcher m=p.matcher("123-34345");
        boolean yesorno=m.matches();

        System.out.println(yesorno);
        System.out.println(m.find());
        System.out.println(m.start());
        System.out.println(m.group());
        System.out.println(m.find());
        System.out.println(m.start());
        System.out.println(m.group());
        // System.out.println(m.find());
        // System.out.println(m.find());
        // System.out.println(m.find());
    }
}
