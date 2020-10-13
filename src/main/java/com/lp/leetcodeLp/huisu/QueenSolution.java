package com.lp.leetcodeLp.huisu;

import java.util.Arrays;

/**
 * @author colter
 * 2018/3/25
 */
public class QueenSolution {
    //修改棋盘的大小，可模拟其他皇后类似问题
    //模拟一个8X8的棋盘，0代表没有放置，1代表放置了一个皇后
    private int[][] board = new int[4][4];

    //放置第K个皇后
    public void putQueen(int k) {
        int max = board.length;
        if (k == max){
            print(board);
            return;
        }
        for (int j = 0; j < board[k].length ; j++) {
            if (check(k,j)){
                board[k][j]=1;
                putQueen(k+1);
                board[k][j]=0;
            }
        }
    }

    /**
     * 皇后放置的时候是从上到下每一行放置的，所以不用检查改行以及之后的行
     * 所以只用检查列以及左上右上对角线
     *
     * @param row 检查的对应行
     * @param col 检查的对应列
     * @return 返回改点是否满足可以放置一个皇后
     */
    private boolean check(int row, int col) {
        //检查列是否有皇后
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }

        //检查左上对角线是否有皇后
        for (int m = row - 1, n = col - 1; m >= 0 && n >= 0; m--, n--) {
            if (board[m][n] == 1) {
                return false;
            }
        }

        //检查右上对角线是否有皇后
        for (int m = row - 1, n = col + 1; m >= 0 && n < board[0].length; m--, n++) {
            if (board[m][n] == 1) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        QueenSolution solution = new QueenSolution();
        solution.putQueen(0);
    }
    private void print(int[][] board){
        //第一个 for 循环语句表示以行进行循环，第二个 for 循环语句表示以列进行循环，这样就实现了获取二维数组中每个元素的值的功能
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                System.out.print("  "+board[i][j]);
            }
            System.out.println("\n");
        }
    }
}

