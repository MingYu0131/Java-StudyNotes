package com.JavaStudy.HspMiddleJavaTest.IOStream_.Buffered_;

/**
 * @author mingyu
 * @version 1.0
 * 介绍IO流的两种分类
 * 1、节点流：从一个特定的数据源（file、数组、String）读写数据，如FileReader、FileWriter
 * 2、处理流（包装流）：是节点流的一种封装和升级，底层还是使用各种节点流，但是为程序提供了更强大的读写功能，也更加灵活，如BufferedReader、BufferedWriter
 * 节点流和包装流的区别与联系
 * 1、节点流是底层流、低级流，直接和数据源相接
 * 2、处理流（包装流）包装节点流，既可以消除不同节点流的实现差异，也可以提供更方便的方法来完成输入和输出
 * 3、处理流（包装流）使用了修饰器设计模式，不会直接与数据源相连
 * 处理流的意义
 * 1、性能的提高：主要以增加缓冲的方式来提高输入和输出的效率
 * 2、操作的便携：处理流提供了一系列的方法来一次输入输出大批量的数据，使用更加灵活方便
 * 注意：在包装流关闭时，自动会关闭底层节点流
 */
public class BufferIntro {
}
