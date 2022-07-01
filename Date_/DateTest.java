package com.JavaStudy.HspMiddleJavaTest.Date_;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author mingyu
 * @version 1.0
 * 第一代日期类：Date（精确到毫秒，代表特定的瞬间）和SimpleDateFormat（格式化（日期-》文本）和解析（文本-》日期）日期的类）
 */
public class DateTest {
    public static void main(String[] args) throws ParseException {
        // 1. 获取当前系统时间
        // 2. 这里的 Date 类是在 java.util 包
        // 3. 默认输出的日期格式是国外的方式, 因此通常需要对格式进行转换
        Date date = new Date();
        System.out.println(date);
        Date date1 = new Date(123456);  //通过指定毫秒数得到时间，最终得到距离1970年午夜这么多毫秒的日期
        System.out.println(date1);

        // 1. 创建 SimpleDateFormat 对象，可以指定相应的格式
        // 2. 这里的格式使用的字母是规定好，不能乱写
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy 年 MM 月 dd 日 hh:mm:ss E");
        String formatDate = simpleDateFormat.format(date);  //使用format方法返回格式化的日期字符串
        System.out.println("当前日期："+formatDate);


        // 1. 可以把一个格式化的 String 转成对应的 Date
        // 2. 得到 Date 仍然在输出时，还是按照国外的形式，如果希望指定格式输出，需要转换
        // 3. 在把 String -> Date ， 使用的 sdf 格式需要和你给的 String 的格式一样，否则会抛出转换异常
        String s = "1996 年 01 月 01 日 10:20:30 星期一";
        Date parse = simpleDateFormat.parse(s); //遇到这种异常，用快捷键alt+enter，选择抛给上级处理
        System.out.println("parse=" + simpleDateFormat.format(parse));
    }
}
