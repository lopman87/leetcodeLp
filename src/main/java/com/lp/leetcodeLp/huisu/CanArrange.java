package com.lp.leetcodeLp.huisu;

public class CanArrange {

    public boolean canArrange(int[] arr, int k) {

        return false;
    }

    private int other(int[] arr,int index, int k){
        for (int i = 0; i < arr.length && i != index; i++) {
            if ((arr[i] + arr[index])%k ==0){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[]arr = {1,2,3,4,5,10,6,7,8,9};
        int k = 5;
        CanArrange solution = new CanArrange();
        solution.canArrange(arr, k);
    }
}
