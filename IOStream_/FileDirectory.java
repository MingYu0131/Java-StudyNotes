package com.JavaStudy.HspMiddleJavaTest.IOStream_;

import org.junit.jupiter.api.Test;

import java.io.File;

/**
 * @author mingyu
 * @version 1.0
 * mkdir()创建一级目录
 * mkdirs()创建多级目录
 * delete()删除空目录或文件
 */
public class FileDirectory {
    public static void main(String[] args) {

    }

    //1、判断e:\\news1.txt是否存在，如果存在就删除
    @Test
    public void test1(){
        String path = "e:\\news1.txt";
        File file = new File(path);
        if(file.exists()){
            System.out.println("删除文件成功");
            file.delete();
        }else {
            System.out.println("文件不存在");
        }
    }

    //2、判断e:\\demo 是否存在，存在就删除否则就创建目录
    //这里可以体会到，目录其实也是一种文件，一种特殊的文件
    @Test
    public void test2(){
        String path = "e:\\demo";
        File file = new File(path);
        if(file.exists()){
            if(file.delete()){
                System.out.println("目录删除成功");
            }else {
                System.out.println("目录删除失败");
            }
        }else {
            System.out.println("目录不存在");
            file.mkdir();
        }
    }

    //3、判断e:\\demo\\a\\b\\c 目录是否存在，如果存在就提示已经存在，否则就创建
    @Test
    public void test3(){
        String path = "e:\\demo\\a\\b\\c";
        File file = new File(path);
        if(file.exists()){
            System.out.println("目录已经存在");
        }else {
            System.out.println("目录不存在，创建目录");
            if(file.mkdirs()){
                System.out.println("目录创建成功");
            }else{
                System.out.println("目录创建失败");
            }
        }
    }
}
