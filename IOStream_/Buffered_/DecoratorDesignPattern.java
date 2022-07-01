package com.JavaStudy.HspMiddleJavaTest.IOStream_.Buffered_;

/**
 * @author mingyu
 * @version 1.0
 * 演示BufferedReader、Writer用到的修饰器设计模式
 * 可以看出使用了这种设计模式非常方便，只要在构造器内传入需要使用的Reader或Writer派生类就能使用对应的增强方法
 */
public class DecoratorDesignPattern {
    public static void main(String[] args) {
        BufferedReader_ bufferedReader_ = new BufferedReader_(new FileReader_());
        //调用拓展方法
        bufferedReader_.readFiles(10);

    }
}

//模拟Reader抽象类
abstract class Reader_{
    public void readFile(){}
    public void stringReader(){}
}

//模拟FileReader，属于节点流/低级流
class FileReader_ extends Reader_{
    public void readFile(){
        System.out.println("读取文件！");
    }
}

class StringReader_ extends Reader_{
    public void stringReader(){
        System.out.println("读取字符串！");
    }
}

class BufferedReader_ extends Reader_{
    //将Reader类型定义为属性，这样就可以兼容所有派生自Reader的子类
    private Reader_ reader_;

    //构造器直接传入需要的Reader类型（节点流）
    public BufferedReader_(Reader_ reader_) {
        this.reader_ = reader_;
    }

    //就可以对相应的方法进行拓展，例如基于底层方法读取多轮文件，或者增加缓存byte[] b等等
    public void readFiles(int num){
        for (int i = 0; i < num; i++) {
            reader_.readFile();
        }
    }

    //不想使用拓展的也可以封装一层
    public void readFile(){
        reader_.readFile();
    }
}