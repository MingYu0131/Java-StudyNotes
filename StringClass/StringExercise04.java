package com.JavaStudy.HspMiddleJavaTest.StringClass;

/**
 * @author mingyu
 * @version 1.0
 * 输入字符串，判断有多少个大写字母多少个小写字母多少个数字
 */
public class StringExercise04 {
    public static void main(String[] args) {
        judgeString("asdASD1231111111111111");
    }
    public static void judgeString(String s){
        if(s == null){
            throw new RuntimeException("s不能为null！");
        }
        int upperCaseNum=0;
        int lowerCaseNum=0;
        int numberNum=0;
        char[] chars =s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] >= 'a' && chars[i] <= 'z'){
                lowerCaseNum++;
            }
            else if(chars[i] >= 'A' && chars[i] <= 'Z'){
                upperCaseNum++;
            }
            else if(chars[i] >= '0' && chars[i] <= '9'){
                numberNum++;
            }else{
                throw new RuntimeException("输入的字符串格式只能包含大小写字母和数字！");
            }
        }
        System.out.println("大写字母的个数为：" + upperCaseNum);
        System.out.println("小写字母的个数为：" + lowerCaseNum);
        System.out.println("数字的个数为：" + numberNum);
    }
}
