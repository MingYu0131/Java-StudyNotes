package com.JavaStudy.HspMiddleJavaTest.StringClass;

/**
 * @author mingyu
 * @version 1.0
 * (1)将字符串指定位置部分进行反转，比如将“abcdef”反转为“aedcbf”
 * （2）编写方法
 */
public class StringExercise02 {
    public static void main(String[] args) {

        try {
            System.out.println(reverse1("abcdef", 1, 3));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //使用StringBuilder类的方法实现
    public static String reverse1(String str, int start, int end){
        //需要进行异常处理
        //重要编程思想：写异常处理时，不正确的情况不容易想到，可以想正确的情况然后取反即可
        if(!(str != null && start>=0 && end >0 && start<end && end <=str.length())){
            throw new RuntimeException("参数不正确！");
        }
        StringBuilder sb = new StringBuilder(str);
        StringBuilder tempSb = new StringBuilder(sb.substring(start, end));
        tempSb = tempSb.reverse();
        sb.replace(start, end, tempSb.toString());
        return sb.toString();

    }

    //使用char[]自己实现
    public static String reverse2(String str, int start, int end){
        //需要进行异常处理
        //重要编程思想：写异常处理时，不正确的情况不容易想到，可以想正确的情况然后取反即可
        if(!(str != null && start>=0 && end >0 && start<end && end <=str.length())){
            throw new RuntimeException("参数不正确！");
        }

        char[] values = str.toCharArray();//先转成char数组，因为String类的字符数组是final的
        char[] chars = new char[end - start];//将来要替换的字符数组

        for (int i = end-1,charsIndex = 0; i >= start; i--) {
            chars[charsIndex++] = values[i];
        }
        for (int i = start,charsIndex = 0; i < end; i++) {
            values[i] = chars[charsIndex++];
        }
        return new String(values);
    }
}
