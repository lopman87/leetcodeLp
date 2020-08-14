package com.lp.leetcodeLp.design;

public class MyHashSet {

    /** Initialize your data structure here. */
    public MyHashSet() {

    }

    public void add(int key) {

    }

    public void remove(int key) {

    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return false;
    }


    public static void main(String[] args){
        MyHashSet queue = new MyHashSet();
        queue.add(1);
        queue.remove(2);
        System.out.println(queue.contains(2));;  // 返回 1
        System.out.println(queue.contains(3));   // 返回 1
        System.out.println(queue.contains(4)); // 返回 false

    }
}
