package com.JavaStudy.HspMiddleJavaTest.Reflection_.Class_;

/**
 * @author mingyu
 * @version 1.0
 * 内容：类加载又分为三个阶段：1、加载Loading：将类的Class文件读入内存，并为之创建一个Class对象
 *                          2、连接Linking((1)验证verification (2)准备preparation (3)解析resolution)：将类的二进制数据合并到JRE中
 *                              验证：会进行文件格式验证、元数据验证等等，目的是为了确保Class文件的字节流中包含的信息不会危害ＪＶＭ的安全
 *                              准备：ＪＶＭ会在该阶段对静态变量，分配内存并进行默认初始化（无论程序员是否对其进行初始化）
 *                              解析：JVM将常量池内的符号引用替换为直接引用的过程
 *                          3、初始化Initialization：初始化阶段才开始真正执行类中定义的java代码，此阶段会执行<clinit>()方法，该方法
 *                          是由编译器按语句在源文件中出现的顺序，依次自动收集类中的所有静态变量的赋值动作和静态代码块中的语句，并进行合并
 *                          而且会有同步机制，以防止多线程时出现数据错乱：
 *                          //正因为有这个机制，才能保证某个类在内存中, 只有一份 Class 对象
 *                          synchronized (getClassLoadingLock(name)) { //.... }
 *
 */
public class ClassLoad02 {
    public static void main(String[] args) {

    }
}

class Cat{
    //n1是实例变量不是静态变量，因此在准备阶段，不会分配内存
    public int n1 = 10;
    //n2是静态变量，在连接的准备阶段，会先被默认初始化为0，分配内存空间
    public static int n2 = 20;
    //n3是static final常量，常量一旦赋值就无法改变，在连接的准备阶段会直接被赋值30
    public static final int n3 = 30;
}
