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
public class LFUCache {


    private int capacity = 0;

    private int size = 0;

    private java.util.HashMap<Integer,Node> valMap ;


    public LFUCache(int capacity) {
        this.capacity = capacity;
        valMap = new java.util.HashMap<>(capacity);
    }

    public int get(int key) {
        if (capacity <= 0){
            return -1;
        }
        if (valMap.containsKey(key)){
            Node tmp = valMap.get(key);
            Node newTmp = new Node(tmp.getValue() , tmp.getFrequency()+1, key, System.nanoTime());
            valMap.replace(key,tmp,newTmp);
            return tmp.getValue();
        }
        return -1;
    }

    public void put(int key, int value) {
        if (capacity <= 0){
            return ;
        }
        if (valMap.containsKey(key)  ){
            Node tmp = valMap.get(key);
            Node newTmp = new Node(value , tmp.getFrequency()+1, key,System.nanoTime());
            valMap.replace(key,tmp,newTmp);
        }else{
            if (size >= capacity){
                Node minFreq = findMinfrequency();
                valMap.remove(minFreq.getKey());
                Node newTmp = new Node(value , 0, key, System.nanoTime());
                valMap.put(key,newTmp);
            }else {
                ++size;
                Node newTmp = new Node(value , 0, key, System.nanoTime());
                valMap.put(key,newTmp);
            }
        }
    }

    private Node findMinfrequency(){
        java.util.List<Node> nodeList = new java.util.ArrayList<>(valMap.values());
        nodeList.sort(java.util.Comparator.comparing(Node::getFrequency).thenComparing(Node::getTime));
        return nodeList.get(0);
    }

    private static class Node implements Comparable<Node>{
        int value;
        int key;
        int frequency;

        long time;

        public long getTime() {
            return time;
        }

        public void setTime(long time) {
            this.time = time;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getFrequency() {
            return frequency;
        }

        public void setFrequency(int frequency) {
            this.frequency = frequency;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
        public Node(int value,int frequency,int key,long time){
            this.setFrequency(frequency);
            this.setValue(value);
            this.setKey(key);
            this.setTime(time);
        }


        @Override
        public int compareTo(Node o) {
            return java.util.Comparator.comparing(Node::getFrequency)
                    .thenComparing(Node::getTime)
                    .compare(this, o);
        }
    }


    /**
     * ["LFUCache","put","put","get","put","get","get","put","get","get","get"]
     * [[2],[1,1],[2,2],[1],[3,3],[2],[3],[4,4],[1],[3],[4]]
     *
     *
     * [null,null,null,1,null,-1,3,null,-1,3,4]
     *
     *
     */
    public static void main(String[] args){

        LFUCache cache = new LFUCache( 2 /* capacity (缓存容量) */ );

        cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.get(1));
        cache.put(3,3);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        cache.put(4,4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}
