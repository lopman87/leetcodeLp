package com.lp.leetcodeLp.design;

import java.util.Arrays;

/**
 * 不使用任何内建的哈希表库设计一个哈希集合
 *
 * 具体地说，你的设计应该包含以下的功能
 *
 * add(value)：向哈希集合中插入一个值。
 * contains(value) ：返回哈希集合中是否存在这个值。
 * remove(value)：将给定值从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
 *
 * 示例:
 *
 * MyHashSet hashSet = new MyHashSet();
 * hashSet.add(1);        
 * hashSet.add(2);        
 * hashSet.contains(1);    // 返回 true
 * hashSet.contains(3);    // 返回 false (未找到)
 * hashSet.add(2);          
 * hashSet.contains(2);    // 返回 true
 * hashSet.remove(2);          
 * hashSet.contains(2);    // 返回  false (已经被删除)
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-hashset
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * int[] a = {1, 2, 3};
 *     // make a one bigger
 *     a = Arrays.copyOf(a, a.length + 1);
 *     for (int i : a)
 *         System.out.println(i);
 */
public class MyHashSet {

    int[] array = {};


    /** Initialize your data structure here. */
    public MyHashSet() {

    }

    public void add(int key) {
        for (int a:array) {
            if (a == key){
                return;
            }
        }
        array = Arrays.copyOf(array, array.length + 1);
        array[array.length - 1] = key;
    }

    public void remove(int key) {
        for (int i =0 ; i < array.length ; i++) {
            if (array[i] == key){
                remove(key, i);
                return;
            }
        }
    }

    private void remove(int key , int index){
        for (int i = index; i < array.length-1; i++) {
            array[i] = array[i+1];
        }
        array = Arrays.copyOf(array, array.length - 1);
    }


    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        for (int i =0 ; i < array.length ; i++) {
            if (array[i] == key){
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args){
        MyHashSet queue = new MyHashSet();
        queue.add(2);
        System.out.println(queue.contains(2));;  // 返回 1
        queue.remove(2);
        System.out.println(queue.contains(2));   // 返回 1
    }
}
