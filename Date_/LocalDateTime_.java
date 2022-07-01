package com.JavaStudy.HspMiddleJavaTest.Date_;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author mingyu
 * @version 1.0
 * 第三代日期，主要优化了前两代的线程安全问题，在JDK8之后引入
 * 主要有三个类：LocalDate（日期/年月日）、LocalTime（只有时间/时分秒）、LocalDateTime（日期时间/年月日时分秒）
 */
public class LocalDateTime_ {
    public static void main(String[] args) {
        //1. 使用 now() 返回表示当前日期时间的 对象
        LocalDateTime ldt = LocalDateTime.now();
        //2. 使用 DateTimeFormatter 对象来进行格式化
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatTime = dtf.format(ldt);
        System.out.println("格式化的时间为："+formatTime);

        System.out.println("年=" + ldt.getYear());
        System.out.println("月=" + ldt.getMonth());
        System.out.println("月=" + ldt.getMonthValue());
        System.out.println("日=" + ldt.getDayOfMonth());
        System.out.println("时=" + ldt.getHour());
        System.out.println("分=" + ldt.getMinute());
        System.out.println("秒=" + ldt.getSecond());

        LocalDate now = LocalDate.now(); //可以获取年月日
        LocalTime now2 = LocalTime.now();//获取到时分秒

        //提供 plus 和 minus 方法可以对当前时间进行加或者减
        // 看看 890 天后，是什么时候 把 年月日-时分秒
        LocalDateTime localDateTime = ldt.plusDays(890);
        System.out.println("890 天后=" + dtf.format(localDateTime));

        //看看在 3456 分钟前是什么时候，把 年月日-时分秒输出
        LocalDateTime localDateTime2 = ldt.minusMinutes(3456);
        System.out.println("3456 分钟前 日期=" + dtf.format(localDateTime2));


        //Instant时间戳，类似于Date，可以和Date互相转换
        //1.通过 静态方法 now() 获取表示当前时间戳的对象
        Instant now1 = Instant.now();
        System.out.println(now1);
        //2. 通过 from 可以把 Instant 转成 Date
        Date date = Date.from(now1);
        //3. 通过 date 的 toInstant() 可以把 date 转成 Instant 对象
        Instant instant = date.toInstant();
    }
}
