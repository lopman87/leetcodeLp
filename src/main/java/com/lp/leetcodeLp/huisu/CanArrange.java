package com.lp.leetcodeLp.huisu;

import java.util.HashSet;
import java.util.Set;

public class CanArrange {

    public boolean canArrange(int[] arr, int k) {
        Set<Integer> used = new HashSet<>();
        for (int i = 0; i < arr.length && !used.contains(i); i++) {
            int pair = other(arr , i,k);
            if (pair != -1){
                used.add(i);
                used.add(pair);
            }
        }
        if (used.size() == arr.length)return true;
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
        int[]arr = {-4,-7,5,2,9,1,10,4,-8,-3};
        int k = 3;
        CanArrange solution = new CanArrange();
        System.out.println(solution.canArrange(arr, k));
    }
}
