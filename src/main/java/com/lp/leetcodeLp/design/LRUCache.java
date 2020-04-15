package com.lp.leetcodeLp.design;



/**
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥已经存在，则变更其数据值；如果密钥不存在，则插入该组「密钥/数据值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *
 *  
 *
 * 进阶:
 *
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 *
 *  https://leetcode-cn.com/problems/lru-cache/
 *
*/
public class LRUCache extends java.util.LinkedHashMap {

    @Override
    public boolean removeEldestEntry(java.util.Map.Entry eldest) {
        return size > capacity;
    }
    private int capacity = 0;

    private int size = 0;

    public LRUCache(int capacity) {
        super(capacity,0.75f,true);
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

    /**
     * ["put","put","put","put","put","get","put","get","get","put","get","put","put","put","get","put","get","get","get","get","put","put","get","get","get","put","put","get","put","get","put","get","get","get","put","put","put","get","put","get","get","put","put","get","put","put","put","put","get","put","put","get","put","put","get","put","put","put","put","put","get","put","put","get","put","get","get","get","put","get","get","put","put","put","put","get","put","put","put","put","get","get","get","put","put","put","get","put","put","put","get","put","put","put","get","get","get","put","put","put","put","get","put","put","put","put","put","put","put"]
     * [[2,14],[1],[5],[4],[11,4],[12,24],[5,18],[13],[7,23],[8],[12],[3,27],[2,12],[5],[2,9],[13,4],[8,18],[1,7],[6],[9,29],[8,21],[5],[6,30],[1,12],[10],[4,15],[7,22],[11,26],[8,17],[9,29],[5],[3,4],[11,30],[12],[4,29],[3],[9],[6],[3,4],[1],[10],[3,29],[10,28],[1,20],[11,13],[3],[3,12],[3,8],[10,9],[3,26],[8],[7],[5],[13,17],[2,27],[11,15],[12],[9,19],[2,15],[3,16],[1],[12,17],[9,1],[6,19],[4],[5],[5],[8,1],[11,7],[5,2],[9,28],[1],[2,2],[7,4],[4,22],[7,24],[9,26],[13,28],[11,26]]
     * @param args
     */
    public static void main(String[] args){
        LRUCache cache = new LRUCache( 10 );

        cache.put(10,13);
        cache.put(3,17);cache.put(6,11);cache.put(10,5);cache.put(9,10);
        System.out.println(cache.get(13));
        cache.put(2,19);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        cache.put(5,25);
        System.out.println(cache.get(8));cache.put(9,22);cache.put(5,5);cache.put(1,30);
        System.out.println(cache.get(11));
        cache.put(9,12);
        System.out.println(cache.get(7));
        System.out.println(cache.get(5));
        System.out.println(cache.get(8));
        System.out.println(cache.get(9));
        cache.put(4,30);
        cache.put(9,3);
        System.out.println(cache.get(9));
        System.out.println(cache.get(10));
        System.out.println(cache.get(10));cache.put(6,14);cache.put(3,1);
        System.out.println(cache.get(3));cache.put(10,11);
        System.out.println(cache.get(8));
        cache.put(2,14);
        System.out.println(cache.get(1));
        System.out.println(cache.get(5));
        System.out.println(cache.get(4));
        cache.put(11,4);
        cache.put(12,24);cache.put(5,18);System.out.println(cache.get(13));cache.put(7,23);System.out.println(cache.get(8));System.out.println(cache.get(12));cache.put(3,27);
        cache.put(2,12);System.out.println(cache.get(5));cache.put(2,9);cache.put(13,4);cache.put(8,18);cache.put(1,7);System.out.println(cache.get(6));cache.put(9,29);
        cache.put(8,21);System.out.println(cache.get(5));cache.put(6,30);
    }
}
