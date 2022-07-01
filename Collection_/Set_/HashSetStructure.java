package com.JavaStudy.HspMiddleJavaTest.Collection_.Set_;

/**
 * @author mingyu
 * @version 1.0
 * 实现一下HashSet/HashMap 底层使用的数组加链表（哈希表/线性链表）的简易版
 * 哈希表直接使用数组效率不高，使用链表与数组的组合效率更高
 * 在实际使用中当Hashtable的大小超过64后，会自动转为红黑树（效率更高）
 */
public class HashSetStructure {
    public static void main(String[] args) {
        //称这种结构为表
        Node[] table = new Node[16];
        table[3] = new Node("mybb", null);
        table[3].next = new Node("hmyy", null); //挂载到后面
        table[3].next.next = new Node("wmyy", null);

        table[4] = new Node("sbb", null);


    }
}
class Node{
    Object item;
    Node next;

    public Node(Object item, Node next) {
        this.item = item;
        this.next = next;
    }

}