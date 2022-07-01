package com.JavaStudy.HspMiddleJavaTest.IOStream_.Buffered_;

import java.io.*;

/**
 * @author mingyu
 * @version 1.0
 * 演示BufferedInputStream和BufferedOutputStream一起使用实现拷贝二进制文件
 */
public class BufferedStreamCopy {
    public static void main(String[] args) throws Exception {
        String srcPath = "e:\\apex.png";
        String destPath = "e:\\copy.png";
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        byte[] b = new byte[1024];
        int readData = 0;
        bis = new BufferedInputStream(new FileInputStream(srcPath));
        bos = new BufferedOutputStream(new FileOutputStream(destPath));
        while ((readData = bis.read(b)) != -1){
            bos.write(b, 0, readData);
        }
        bis.close();
        bos.close();
    }
}
