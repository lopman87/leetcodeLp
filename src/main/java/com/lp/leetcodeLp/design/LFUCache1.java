package com.lp.leetcodeLp.design;



public class LFUCache1 {

    private java.util.TreeMap<Node,Integer> nodeIntegerTreeMap;

    private int capacity = 0;

    private int size = 0;

    private java.util.HashMap<Integer, Node> valMap ;
    public LFUCache1(int capacity) {
        nodeIntegerTreeMap = new java.util.TreeMap<>();
        this.capacity = capacity;
        valMap = new java.util.HashMap<>(capacity);
    }

    public int get(int key) {
        if (capacity <= 0){
            return -1;
        }
        if (valMap.containsKey(key)){

            Node tmp = valMap.get(key);

            nodeIntegerTreeMap.remove(tmp);


            Node newTmp = new Node(tmp.getValue() , tmp.getFrequency()+1, key, System.nanoTime());

            nodeIntegerTreeMap.put(newTmp , newTmp.getValue());

            valMap.replace(key,tmp,newTmp);
            return tmp.getValue();
        }
        return -1;
    }

    public void put(int key, int value) {
        if (capacity <= 0){
            return ;
        }
        if (valMap.containsKey(key)){
            Node tmp = valMap.get(key);
            Node newTmp = new Node(value , tmp.getFrequency()+1, key,System.nanoTime());
            valMap.replace(key,tmp,newTmp);

            nodeIntegerTreeMap.remove(tmp);

            nodeIntegerTreeMap.put(newTmp , newTmp.getValue());
        }else{
            if (size >= capacity){
                java.util.Map.Entry<Node,Integer> minFreq = nodeIntegerTreeMap.pollFirstEntry();
                valMap.remove(minFreq.getKey().getKey());
                Node newTmp = new Node(value , 0, key, System.nanoTime());
                valMap.put(key,newTmp);
                nodeIntegerTreeMap.put(newTmp, key);
            }else {
                ++size;
                Node newTmp = new Node(value , 0, key, System.nanoTime());
                valMap.put(key,newTmp);
                nodeIntegerTreeMap.put(newTmp, key);
            }
        }
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
     * ["LFUCache","put","put","get","put","put","get"]
     * [[2],[2,1],[2,2],[2],[1,1],[4,1],[2]]
     *
     *
     * [null,null,null,2,null,null,2]
     *
     *
     */
    public static void main(String[] args){

        LFUCache1 cache = new LFUCache1( 2/* capacity (缓存容量) */ );

        cache.put(2,1);
        cache.put(2,2);
        System.out.println(cache.get(2));
        cache.put(1,1);
        cache.put(4,1);
        System.out.println(cache.get(2));
    }
}
