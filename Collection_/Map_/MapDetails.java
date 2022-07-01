package com.JavaStudy.HspMiddleJavaTest.Collection_.Map_;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author mingyu
 * @version 1.0
 * 注意：这里讲的是JDK8的Map接口特点
 * 1、Map与Collection是并列存在的两个接口，是两种不同的集合
 * 2、Map用于保存具有映射关系的Key-Value数据，可以是任何引用类型数据，会封装到HashMap$Node对象中
 * 3、Map中的Key不允许重复
 * 4、Map中的Value可以重复
 * 5、Map中的Key和Value可以为null
 * 6、常常用String作为Map的Key
 * 7、Key和Value之间存在单向一对一的关系，即通过唯一key总能找到唯一value，反之不行
 * 8、Map存放数据的Key-value，一对k-v底层是存放在一个HashMap$Node（table）中的，又因为Node实现了Entry接口，有些书也说一对k-v就是一个Entry
 *    HashMap$EntrySet并没有存储数据，只是做了个指向HashMap$Node（table），之所以实现HashMap$EntrySet是为了方便遍历
 *    通过观察底层可以看到Map.Entry声明了两个非常重要的功能 K getKey();  V getValue();(具体查看P666)
 *    其实就是一个map 里面有4个集合 一个map 集合， 一个 entrySet集合（保存KV关系） 一个 set集合（keySet，保存Key） 一个  collection集合（保存Value）
 */
public class MapDetails {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put("no1", "mybb");
        hashMap.put("no2", "sbb");
        hashMap.put("no3", "dbb");
        hashMap.put("no1", "obb");  //会替换mybb，因为key不能重复
        hashMap.put("no3", "obb");  //会替换dbb，不会替换no1，因为value可以重复
        hashMap.put(null, null);    //null也可以保存
        System.out.println(hashMap.get("no3"));
        System.out.println(hashMap.get("no1")); //单向一对一
        System.out.println(hashMap);    //存放顺序和取出顺序不一致（和HashMap一样，因为index下标是hash值计算的）

        //演示一下底层的Entry
        Set set = hashMap.entrySet();
        for (Object o : set) {
            //实现了Map.Entry接口，所以可以向上转型，从而调用Map.Entry的两个重要方法
            Map.Entry e = (Map.Entry) o;
            System.out.println(((Map.Entry<?, ?>) o).getKey()+"-"+((Map.Entry<?, ?>) o).getValue());
        }


    }
}
