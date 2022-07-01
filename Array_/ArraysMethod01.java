package com.JavaStudy.HspMiddleJavaTest.Array_;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author mingyu
 * @version 1.0
 */
public class ArraysMethod01 {
    public static void main(String[] args) {
        Integer[] integer = {1, -12, 15, 3};
        //传统的遍历方法
//        for (int i = 0; i < integer.length ; i++) {
//            System.out.println(integer[i]);
//        }
        //直接使用Arrays.toString 方法，显示数组，方便快捷
        System.out.println(Arrays.toString(integer));

        //Arrays.sort() 分为默认和定制排序
        //sort 重载，可以通过传入一个接口 Comparator 实现定制排序
        // 调用 定制排序 时，传入两个参数 (1) 排序的数组 arr (2) 实现了 Comparator 接口的匿名内部类 , 要求实现 compare 方法
        Arrays.sort(integer);
        System.out.println(Arrays.toString(integer));

        //这里体现了接口编程的方式 , 看看源码，就明白
        //(1) Arrays.sort(arr, new Comparator()
        // (2) 最终到 TimSort 类的 private static <T> void binarySort(T[] a, int lo, int hi, int start,Comparator<? super T> c)()
        // (3) 执行到 binarySort 方法的代码, 会根据动态绑定机制 c.compare()执行我们传入的匿名内部类的 compare ()
        // while (left < right) {
        //                int mid = (left + right) >>> 1;
        //                if (c.compare(pivot, a[mid]) < 0)
        //                    right = mid;
        //                else
        //                    left = mid + 1;
        //            }
        //(4) public int compare(Object o1, Object o2) 返回的值>0 还是 <0 会影响整个排序结果,
        // 这就充分体现了 接口编程+动态绑定+匿名内部类的综合使用,将来的底层框架和源码的使用方式，会非常常见
        Arrays.sort(integer, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1; //互换一下就是从大到小了，可以使用断点看一下执行的逻辑
            }
        });
        System.out.println(Arrays.toString(integer));
    }
}
