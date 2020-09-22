package com.lp.leetcodeLp.dp;

/**
 * 01背包问题
 * F[i][j]表示前i件物品中选取若干件物品放入剩余空间为j的背包中所能得到的最大价值
 * 根据第i个物品放入或不放入进行选择
 *
 *
 * 其中F[i-1][j]表示前i-1件物品中选取若干件物品放入剩余空间为j的背包中所能得到的最大价值；
 * 而F[i-1]j-C[i]]+W[i]表示前i-1件物品中选取若干件物品放入剩余空间为j-C[i]的背包中所能取得的最大价值加上第i件物品的价值
 *
 * 作者：lopman87
 * 链接：https://juejin.im/post/6872343190457253895
 * 来源：掘金
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Backpack01 {

    /**
     *
     * @param weight 各个物品的重量
     * @param value 各个物品的价值
     * @param w 背包容量
     * @param n 物品个数
     * @return
     */
    public static int getMaxValue(int[] weight, int[] value, int w, int n) {
        int[][] table = new int[n + 1][w + 1];
        for (int i = 1; i < table.length; i++) {
            for (int j = 1; j < table[i].length; j++) {
                int notChooseI = table[i-1][j];
                int chooseI = 0;
                if (j>weight[i] ){
                    chooseI = table[i-1][j - weight[i]] + value[i];
                }
                table[i][j] = Math.max(notChooseI , chooseI);
            }
        }
        return table[n][w];
    }

    public static void main(String[] args) {

        int n = 5, w = 10;                    //物品个数，背包容量
        int[] value = {0, 6, 3, 5, 4, 6};     //各个物品的价值
        int[] weight = {0, 2, 2, 6, 5, 4};    //各个物品的重量
        System.out.println(getMaxValue(weight,value,w,n));

    }
}
