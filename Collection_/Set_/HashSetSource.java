package com.JavaStudy.HspMiddleJavaTest.Collection_.Set_;

import java.util.HashSet;

/**
 * @author mingyu
 * @version 1.0
 * 分析HashSet底层是如何添加元素的（hash()+equals()）
 * 0.使用线性链表存储
 * 1.HashSet底层是HashMap
 * 2.添加一个元素时，先得到hash值，然后转化成索引值
 * 3.找到存储数据表table，看这个索引位置是否已经存放元素
 * 4.如果没有存放就直接加入
 * 5.如果有就调用equals比较，如果相同就放弃添加，如果不相同就添加到最后
 * （这就是为什么new String（）会不能添加重复元素的原因，因为String已经重写了equals，比较的是内容）
 * 6.在java8中，如果一条链表的元素个数到达TREEIFY_THRESHOLD(默认为8)，并且table的大小>=MIN_TREEIFY_CAPACITY(默认64)，就会进行树化（红黑树）
 * 7.如果只是一条链表的元素个数到达TREEIFY_THRESHOLD(默认为8)，而table大小没达到临界值，会进行resize() 两倍扩容，新插入的值还是会在那条链表的尾部（8 -> 9）
 */
public class HashSetSource {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        hashSet.add("java");
        hashSet.add("mybb");
        hashSet.add("java");
        System.out.println("Set = "+hashSet);
        /*解读HashSet的add方法源码
        1、执行HashSet的无参构造器（可以看出HashSet底层是HashMap）
            public HashSet() {
                map = new HashMap<>();
            }
        2、执行add()，e就是"java"
        public boolean add(E e) {
                //注意put方法如果put成功就会返回一个null,所以return的是是否put成功
                return map.put(e, PRESENT)==null;
                 //注意这里的PRESENT是一个空object对象，因为底层调用的是K-V集合HashMap，需要满足格式
            }
        3、执行put()，封装了putval()方法
        public V put(K key, V value) {//K就是"java"，V是空Object PRESENT
        // hash(key) 得到 key 对应的 hash 值的算法 h = key.hashCode()) ^ (h >>> 16)，这样计算可以有助于避免冲突碰撞提高性能
            return putVal(hash(key), key, value, false, true);
        }
        4、执行核心的putVal方法
        final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
            Node<K,V>[] tab; Node<K,V> p; int n, i;     //定义了辅助变量
            //第一个if判断的就是当前的table是否为null或者大小为0，那么就进行第一次扩容，到16个空间
            if ((tab = table) == null || (n = tab.length) == 0)
                //resize() 方法专门用来扩容
                n = (tab = resize()).length;

            //第二个if判断当前计算的hash值对应的index是否为null，如果为null，直接挂载就可以
            //注意这里说明了下标和hash值的转换公式 -> index = i = (n - 1) & hash，将较大的hash值映射到数组大小尺度的数轴上
            if ((p = tab[i = (n - 1) & hash]) == null)
                tab[i] = newNode(hash, key, value, null);
            else {
                Node<K,V> e; K k;
                //内层的if判断当前的K是否和已经存在的元素重复（通过equals方法判断，由程序员决定）
                //判断当前待插入元素的hash和hash是否相等（应该是遇到扩容等情况会不相等）
                if (p.hash == hash &&
                    //判断是否是同一个对象（地址都一样，是同一个对象不用比了肯定不行） 或  调用该对象的equals方法判断是否相等
                    ((k = p.key) == key || (key != null && key.equals(k))))
                    e = p;      //保存当前重复的值
                //判断当前是否已经树化，要是红黑树化，直接使用树的put方法
                else if (p instanceof TreeNode)
                    e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
                //既不是重复的元素，也没有树化，那么对该index线性表对应的链表进行遍历，最后可能遇到重复元素break，也可能没有重复元素最终挂载到最后
                else {
                    for (int binCount = 0; ; ++binCount) {
                        //这个if代表当前已经遍历到了最后一个元素的next，这也意味着没有重复元素，直接在尾部挂载
                        if ((e = p.next) == null) {
                            p.next = newNode(hash, key, value, null);
                            //注意这个binCount如果达到了树化的临界值也会尝试执行treeifyBin()，如果真的满足了树化的条件：
                            （同一个index线性表的链表节点个数到达TREEIFY_THRESHOLD(默认为8)，并且table的大小>=MIN_TREEIFY_CAPACITY(默认64)）就会树化，否则只是resize()两倍扩容一下
                            if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                                treeifyBin(tab, hash);
                            break;
                        }
                        //如果遇到重复的元素，直接break
                        if (e.hash == hash &&
                            ((k = e.key) == key || (key != null && key.equals(k))))
                            break;
                        p = e;      //每次循环结束执行，和上面的e = p.next组合，达到遍历链表的效果
                    }
                }
                //出现重复情况后，也要保存重复的值，可以进一步进行处理（并不是直接丢弃）
                if (e != null) { // existing mapping for key
                    V oldValue = e.value;
                    if (!onlyIfAbsent || oldValue == null)
                        e.value = value;
                    //afterNodeAccess(e);空的方法，留给程序员DIY如何处理这种重复值
                    afterNodeAccess(e);
                    return oldValue;
                }
            }
            ++modCount;     //修改次数加1
            if (++size > threshold)
                resize();
             //afterNodeInsertion(evict);空的方法，留给程序员DIY元素插入后应该干什么（树化后就用到了），evict为true代表启用这个方法
            afterNodeInsertion(evict);
            //插入成功后就会返回null，put成功的标志
            return null;
    }

         */
    }
}
