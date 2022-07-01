package com.JavaStudy.HspMiddleJavaTest.Collection_.List_;

/**
 * @author mingyu
 * @version 1.0
 * vector和ArrayList类似，也是线性表集合但是二者又有区别
 *            底层结构    版本        线程安全             扩容倍数
 * ArrayList  可变数组    JDK1.2      不安全，效率高     如果有参构造1.5倍，如果无参1、第一次默认10 2、第二次开始1.5倍扩容
 * Vector     可变数组    JDK1.0      安全，效率低       如果是无参默认10，之后按2倍扩容。如果有参构造，每次扩容直接2倍
 */
public class Vector_ {
}
