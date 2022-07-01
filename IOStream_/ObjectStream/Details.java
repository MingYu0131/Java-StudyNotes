package com.JavaStudy.HspMiddleJavaTest.IOStream_.ObjectStream;

/**
 * @author mingyu
 * @version 1.0
 * 1、读取顺序要一致
 * 2、要求序列化或反序列化的对象，要实现Serializable接口
 * 3、序列化的类中建议添加SerialVersionUID，可以提高版本的兼容性（解释见Dog_类）
 * 4、序列化对象时，默认将里面所有的属性都进行了序列化，但是处理static或transient（这个关键字就代表不想序列化）修饰的成员
 * 5、序列化对象时，要求里面的属性的类型也需要实现序列化接口
 * 6、序列化具备可继承性，父类实现了序列化，子类也默认实现了序列化
 */
public class Details {
}
