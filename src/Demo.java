import com.imooc.basic.util.Md5Util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo {

    public static void main(String[] args) throws ParseException {
        /*int i=0,j=1;
        i++;
        ++j;
        System.out.println(i);
        System.out.println(j);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse("2019-11-18");
        System.out.println(date.getTime());*/
        //test2();
        String s = "docCreator.fdLoginName";
        System.out.println((s.split("\\."))[0]);
    }

    public void test1(){
        String fdLoginName = "jf004712";
        String time = "2020-03-31 00:00";
        String key = Md5Util.strToMd5(fdLoginName+time);

    }

    public static void test2(){
        //char grade = args[0].charAt(0);
        char grade = 'C';

        switch(grade)
        {
            case 'A' :
                System.out.println("优秀");
                break;
            case 'B' :
            case 'C' :
                System.out.println("良好");
                break;
            case 'D' :
                System.out.println("及格");
                break;
            case 'F' :
                System.out.println("你需要再努力努力");
                break;
            default :
                System.out.println("未知等级");
        }
        System.out.println("你的等级是 " + grade);
    }
}
