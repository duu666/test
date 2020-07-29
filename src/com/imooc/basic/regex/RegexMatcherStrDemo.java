package com.imooc.basic.regex;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatcherStrDemo {

    public static void main(String[] args) {
        //test1();
        test2();
    }

    public static void test1(){
        String regex = "\\w(\\d\\d)(\\w+)";
        String candidate = "x99SuperJava";

        Pattern p = Pattern.compile(regex);
        Matcher matcher = p.matcher(candidate);
        if(matcher.find()){
            int gc = matcher.groupCount();
            for(int i = 0; i <= gc; i++)
                System.out.println("group " + i + " :" + matcher.group(i));
        }
    }

    public static void test2(){
        /*String regex = "^1[3|4|5|8][0-9]\\d{8}$";
        String mobile = "13512713320";
        Pattern p= Pattern.compile(regex );
        System.out.println(p.matcher(mobile).group(0));*/
        String regex = "\\d{9}$";
        String regex2 = "[0-9]{8}[0-9]";
        String regex3 = "^[A-Za-z0-9]+$";
        String regex4 = "\\d+";
        String regex5 = "\\.";
        String regex6 = "[\\d+\\s\\:\\-]";
        Pattern pattern= Pattern.compile(regex2);
        Pattern pattern2= Pattern.compile(regex5);
        Pattern pattern3= Pattern.compile(regex6);
        Pattern pattern4= Pattern.compile("考勤记录重复");
        String str = "新增考勤记录1956条,有95条插入失败,具体信息为:第11条记录,000009840工号不存在.第25条记录,000010574工号不存在.第49条记录,000010722工号不存在.第51条记录,000010631工号不存在.:第9条记录,人员编号为000004833 2020-03-11 18:01:18考勤记录重复.第10条记录,人员编号为000005561 2020-03-11 18:01:22考勤记录重复.";
        Matcher matcher = pattern.matcher(str);
        boolean match = matcher.find();
        int index = 0;
        while (match) {
            System.out.println("group " + 0 + " :" + matcher.group(0));
            index = matcher.end(0);
            String tempStr = str.substring(index);
            pattern.matcher(tempStr);
            match = matcher.find();

            Matcher matcher2 = pattern2.matcher(tempStr);
            if  (matcher2.find()) {
                String tem2 = tempStr.substring(0,matcher2.end(0)-1);
                System.out.println("childgroup " + 0 + " :" + tem2);
                if (tem2.contains("考勤记录重复")) {
                    int endIndex = tem2.indexOf("考勤记录重复");
                    System.out.println(tem2.substring(1,endIndex));
                }
            }
        }

        System.out.println(valiDateTimeWithLongFormat("2015-02-27 08:02:02"));
        //System.out.println(matcher.group(1));
    }

    /**
     * 验证时间字符串格式输入是否正确
     * @param timeStr
     * @return
     */
    public static boolean valiDateTimeWithLongFormat(String timeStr) {
        String format = "((19|20)[0-9]{2})-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01]) "
                + "([01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]";
        Pattern pattern = Pattern.compile(format);
        Matcher matcher = pattern.matcher(timeStr);
        if (matcher.matches()) {
            pattern = Pattern.compile("(\\d{4})-(\\d+)-(\\d+).*");
            matcher = pattern.matcher(timeStr);
            if (matcher.matches()) {
                int y = Integer.valueOf(matcher.group(1));
                int m = Integer.valueOf(matcher.group(2));
                int d = Integer.valueOf(matcher.group(3));
                if (d > 28) {
                    Calendar c = Calendar.getInstance();
                    c.set(y, m-1, 1);
                    int lastDay = c.getActualMaximum(Calendar.DAY_OF_MONTH);
                    return (lastDay >= d);
                }
            }
            return true;
        }
        return false;
    }
}
