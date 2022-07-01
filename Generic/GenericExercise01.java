package com.JavaStudy.HspMiddleJavaTest.Generic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author mingyu
 * @version 1.0
 * 使用泛型在hashmap创建对象，并使用两种方法遍历
 */



public class GenericExercise01 {

    public static void main(String[] args) {
        HashMap<String, Stu> stringStuHashMap = new HashMap<>();
        stringStuHashMap.put("mybb", new Stu("mybb"));
        stringStuHashMap.put("ddbb", new Stu("ddbb"));
        stringStuHashMap.put("sybb", new Stu("sybb"));

        Set<Map.Entry<String, Stu>> entries = stringStuHashMap.entrySet();
        Iterator<Map.Entry<String, Stu>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Stu> next =  iterator.next();
            System.out.println(next.getKey() + "-" + next.getValue());
        }

        Set<String> keySet = stringStuHashMap.keySet();
        for (String o :keySet) {
            System.out.println(o + "-" + stringStuHashMap.get(o));
        }


    }

}

class Stu{
    String name;

    public Stu(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Stu{" +
                "name='" + name + '\'' +
                '}';
    }
}
