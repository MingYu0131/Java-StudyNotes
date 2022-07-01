package com.JavaStudy.HspMiddleJavaTest.Collection_.Map_;

import java.util.*;

/**
 * @author mingyu
 * @version 1.0
 * 展示Map接口实现类的六种遍历方式,使用如下的案例辅助理解HashMap的存储结构
 * Map存放数据的Key-value，一对k-v底层是存放在一个HashMap$Node（table）中的，又因为Node实现了Entry接口，有些书也说一对k-v就是一个Entry
 *  *    HashMap$EntrySet并没有存储数据，只是做了个指向HashMap$Node（table），之所以实现HashMap$EntrySet是为了方便遍历
 *  *    通过观察底层可以看到HashMap$EntrySet实现的接口Map.Entry声明了两个非常重要的功能 K getKey();  V getValue();(具体查看P666)
 *  *    其实就是一个map里面有4个集合，一个map集合，一个 entrySet集合（保存KV关系），一个 set集合（keySet()，保存Key），一个collection集合（values(),保存Value）
 */
@SuppressWarnings({"all"})
public class MapFor {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("邓超", "孙俪");
        map.put("王宝强", "马蓉");
        map.put("宋喆", "马蓉");
        map.put("刘令博", null);
        map.put(null, "刘亦菲");
        map.put("鹿晗", "关晓彤");

        //第一组，使用keySet()方法，取出所有的key然后通过key，get到所有的value
        Set keySet = map.keySet();
        //（1.1）增强for
        System.out.println("-------第一种方法-------");
        for (Object key :keySet) {
            System.out.println(key + "-" + map.get(key));
        }
        //（1.2）迭代器
        System.out.println("-------第二种方法-------");
        Iterator iterator1 = keySet.iterator();
        while (iterator1.hasNext()) {
            Object key =  iterator1.next();
            System.out.println(key + "-" + map.get(key));
        }

        //第二组，使用Value方法把所有value取出，只能遍历value
        Collection values = map.values();
        //这里可以使用所有的 Collections 使用的遍历方法(3种)
        //(2.1)增强for
        System.out.println("-------第三种方法-------");
        for (Object o :values) {
            System.out.println(o);
        }
        //(2.2)迭代器
        System.out.println("-------第四种方法-------");
        Iterator iterator2 = values.iterator();
        while (iterator2.hasNext()) {
            Object value =  iterator2.next();
            System.out.println(value);
        }
        //(2.3)普通for
        System.out.println("-------第五种方法-------");
        Iterator iterator3 = values.iterator();
        for (int i = 0; i < values.size(); i++) {
            Object value =  iterator3.next();
            System.out.println(value);
        }

        //使用entrySet获取k-v关系然后遍历
        //(3.1)增强for
        Set set = map.entrySet();// 本质：EntrySet<Map.Entry<K,V>>
        System.out.println("-------第六种方法-------");
        for (Object o :set) {
            Map.Entry e = (Map.Entry) o;
            System.out.println(e.getKey() + "-" + e.getValue());
        }
        //(3.2)迭代器
        Iterator iterator4 = set.iterator();
        System.out.println("-------第七种方法-------");
        while (iterator4.hasNext()) {
            Object entry =  iterator4.next();
            //System.out.println(entry.getClass());//HashMap$Node -这个内部类为了方便遍历Map实现了这个接口-> Map.Entry (getKey,getValue)
            Map.Entry e = (Map.Entry) entry;    //向下转型
            System.out.println(e.getKey() + "-" + e.getValue());
        }


    }
}
