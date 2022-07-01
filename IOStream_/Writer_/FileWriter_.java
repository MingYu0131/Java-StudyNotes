package com.JavaStudy.HspMiddleJavaTest.IOStream_.Writer_;

import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author mingyu
 * @version 1.0
 * 字符流的采用输出类FileWriter，介绍其常用方法writer
 * 使用 FileWriter 将 “风雨之后，定见彩虹” 写入到 note.txt 文件中, 注意细节.
 */
public class FileWriter_ {
    public static void main(String[] args) {

    }

    @Test
    public void FileWriter_(){
        String filePath = "e:\\note.txt";
        FileWriter fileWriter = null;
        char[] chars = {'h','m','y'};
        try {
            //默认是覆盖写入，也可以在构造器加个true变为追加写
            fileWriter = new FileWriter(filePath);
            // 3) write(int):写入单个字符
            fileWriter.write('H');
            // 4) write(char[]):写入指定数组
            fileWriter.write(chars);
            // 5) write(char[],off,len):写入指定数组的指定部分
            fileWriter.write("韩顺平教育".toCharArray(), 0, 3);
            // 6) write（string）：写入整个字符串
            fileWriter.write(" 你好北京~");
            fileWriter.write("风雨之后，定见彩虹");
            // 7) write(string,off,len):写入字符串的指定部分
            fileWriter.write("上海天津", 0, 2);
            //在数据量大的情况下，可以使用循环操作.
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                //注意！！！！！！FileWriter在使用后，必须关闭（close）或刷新（flush），否则写入不到指定文件！
//                fileWriter.flush();//刷新
                //关闭文件流close()，等价于 flush() + 关闭
                //查看源码，最终close和flush都会调用到writeBytes()这个方法，这是真正在写入文件的方法
                //private void writeBytes() throws IOException {
                //        this.bb.flip();
                //        int var1 = this.bb.limit();
                //        int var2 = this.bb.position();
                //
                //        assert var2 <= var1;
                //
                //        int var3 = var2 <= var1 ? var1 - var2 : 0;
                //        if (var3 > 0) {
                //            if (this.ch != null) {
                //                assert this.ch.write(this.bb) == var3 : var3;
                //            } else {
                //                this.out.write(this.bb.array(), this.bb.arrayOffset() + var2, var3);
                //            }
                //        }
                //
                //        this.bb.clear();
                //    }
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
