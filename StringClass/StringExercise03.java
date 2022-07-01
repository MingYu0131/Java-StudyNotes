package com.JavaStudy.HspMiddleJavaTest.StringClass;

import java.util.Locale;

/**
 * @author mingyu
 * @version 1.0
 * 输入形式为： Hu ming Yu的人名，以Yu,Hu .M 的形式打印出来
 */
public class StringExercise03 {
    public static void main(String[] args) {

        System.out.println(nameFormat2("Han shun Ping"));
    }
    public static String nameFormat(String name){
        //最好还要异常检测

        //按这种姓名格式只会有两个空格
        int spaceIndex1 = name.indexOf(' ');
        int spaceIndex2 = name.lastIndexOf(' ');

        return name.substring(spaceIndex2, name.length()) + ',' + name.substring(0, spaceIndex1) +
                " ." + name.substring(spaceIndex1+1, spaceIndex1+2).toUpperCase();
    }

    //先分割再格式化的写法，拓展性比较好
    public static String nameFormat2(String name){
        String[] s = name.split(" ");
        if(s.length != 3){
            throw new RuntimeException("格式有误！");
        }
        return String.format("%s,%s .%s",s[2], s[0],s[1].toUpperCase().charAt(0));
    }
}
