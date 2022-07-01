package com.JavaStudy.HspMiddleJavaTest.Collection_.Exercise;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author mingyu
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class CollectionsExercise03 {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put("jack" , 650);
        hashMap.put("tom" , 1200);
        hashMap.put("smith" , 2900);

        hashMap.put("jack", 2600);

        Set set = hashMap.keySet();
        for (Object key :set) {
            int sal = (int)(hashMap.get(key));
            hashMap.put(key, sal+100);
        }

        Set entrySet = hashMap.entrySet();
        for (Object o :entrySet) {
            Map.Entry e = (Map.Entry) o;
            System.out.println(e.getKey() + "-" + e.getValue());
        }

        Collection values = hashMap.values();
        for (Object o :values) {
            System.out.println(o);
        }


    }
}
