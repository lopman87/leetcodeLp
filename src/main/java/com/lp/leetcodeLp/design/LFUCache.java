package com.lp.leetcodeLp.design;

/**
 * https://leetcode-cn.com/problems/lfu-cache/
 *
 * 请你为 最不经常使用（LFU）缓存算法设计并实现数据结构。它应该支持以下操作：get 和 put。
 *
 * get(key) - 如果键存在于缓存中，则获取键的值（总是正数），否则返回 -1。
 * put(key, value) - 如果键已存在，则变更其值；如果键不存在，请插入键值对。当缓存达到其容量时，则应该在插入新项之前，使最不经常使用的项无效。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除 最近 最少使用的键。
 * 「项的使用次数」就是自插入该项以来对其调用 get 和 put 函数的次数之和。使用次数会在对应项被移除后置为 0 。
 *
 */
public class LFUCache extends java.util.LinkedHashMap {
    @Override
    public boolean removeEldestEntry(java.util.Map.Entry eldest) {
        return size > capacity;
    }
    private int capacity = 0;

    private int size = 0;

    public LFUCache(int capacity) {
        super(capacity,0.75f,false);
        this.capacity = capacity;
    }

    public int get(int key) {
        Object res = super.get(key);
        if (res == null){
            return -1;
        }
        return (Integer)res;
    }

    public void put(int key, int value) {
        if (super.containsKey(key)){
            super.replace(key,value);
        }else{
            ++size;
            super.put(key,value);
        }
    }
    public static void main(String[] args){
        LFUCache cache = new LFUCache( 10 );

        cache.put(10,13);
        cache.put(3,17);cache.put(6,11);cache.put(10,5);cache.put(9,10);
        System.out.println(cache.get(13));
    }
}
