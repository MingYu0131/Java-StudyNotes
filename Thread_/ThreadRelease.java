package com.JavaStudy.HspMiddleJavaTest.Thread_;

/**
 * @author mingyu
 * @version 1.0
 * 什么情况下锁会被释放呢？
 * 1、当前线程的同步方法/同步代码块执行结束
 * 2、当前线程在同步方法/同步代码块中遇到了break/return
 * 3、当前线程在同步方法/同步代码块中出现了未处理的Error或Exception，导致异常结束
 * 4、当前线程在同步方法/同步代码块中执行了对象对象的wait()方法，当前线程暂停了并释放锁
 * 什么情况下不会释放锁？
 * 1、前线程在同步方法/同步代码块，程序调用Thread.sleep()\Thread.yield()方法暂停了当前线程的执行，不会释放锁
 * 2、前线程在同步方法/同步代码块，其他线程调用了该线程的suspend()(已不再使用)方法将该线程挂起，不会释放锁
 */
public class ThreadRelease {
}
