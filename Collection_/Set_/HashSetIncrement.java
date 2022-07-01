package com.JavaStudy.HspMiddleJavaTest.Collection_.Set_;

import java.util.HashSet;
import java.util.Objects;

/**
 * @author mingyu
 * @version 1.0
 * 查看HashSet的扩容现象
 */
public class HashSetIncrement {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        /*
            HashSet第一次add时，默认会扩容为16，此时临界值（threshold）为16*0.75 = 12
            如果table达到了12就会扩容为16*2 = 32，新的临界值就为32 * 0.75 = 24....以此类推
         */
        //进行debug观察table的变化 ：double的过程，但是因为没有在同一个数组元素上挂载链表，满足不了TREEIFY_THRESHOLD（8），所以不会树化
//        for (int i = 0; i < 100; i++) {
//            hashSet.add(i);
//        }
        //观察到第8个时，触发了REEIFY_THRESHOLD（8），会进行一次resize()将table拓展为2倍，当table拓展为64时，就会树化
        for (int i = 0; i < 100; i++) {
            hashSet.add(new A(i));
        }

        //当我们向 hashset 增加一个元素，-> Node -> 加入 table(链表装载的也算) , 就算是增加了一个 size++
    }
}

class A{
    private int n;

    public A(int n) {
        this.n = n;
    }
    //重写hashCode方法从而让每个A对象的hash值相同，就可以在table的同一个index上累计，从而就可以观察
    @Override
    public int hashCode() {
        return 100;
    }
}
