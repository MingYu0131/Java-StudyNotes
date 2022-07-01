package com.JavaStudy.HspMiddleJavaTest.IOStream_.TransformStream;

import java.io.*;

/**
 * @author mingyu
 * @version 1.0
 * 案例：将字节流FileOutputStream包装成字符流OutputStreamWriter，在对文件进行写入，并指定编码格式
 */
public class OutputStreamWriter_ {
    public static void main(String[] args) throws IOException {
        String filePath = "e:\\pp.txt";
        //执行后可以看到文件的编码类型是ANSI（gbk）
        OutputStreamWriter gbkFile = new OutputStreamWriter(new FileOutputStream(filePath), "gbk");
        gbkFile.write("mybb");
        gbkFile.write("胡名鱼鱼");
        gbkFile.close();
    }
}
