package com.JavaStudy.HspMiddleJavaTest.Collection_.Map_;

import java.util.HashMap;

/**
 * @author mingyu
 * @version 1.0
 * 演示HashMap的扩容机制（和HashSet基本相同）
 * 1、HashMap底层维护了Node类型的数组table（数组加链表加红黑树）
 * 2、扩容和添加的细节，具体查看HashSetSource
 */
@SuppressWarnings({"all"})
public class HashMapSource {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put("mybb", 1);
        hashMap.put("java", 1);
        hashMap.put("mybb", 1);

    }
}
