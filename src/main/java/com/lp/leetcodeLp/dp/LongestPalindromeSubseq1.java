package com.lp.leetcodeLp.dp;

public class LongestPalindromeSubseq1 {
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        if (s.length() == 1){
            return 1;
        }
        if (s.length() == 2){
            return s.charAt(0) == s.charAt(1) ? 2 : 1;
        }
        int length = s.length();

        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = 1;
        }
        for (int i = length-1; i >= 0; i--) {
            for (int j = i+1; j < length; j++) {
                if (s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1]+2;
                }else{
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        return dp[0][length-1];
    }



    public static void main(String args[]){
        long start = System.currentTimeMillis();
        LongestPalindromeSubseq1 numTrees = new LongestPalindromeSubseq1();
        System.out.println(numTrees.longestPalindromeSubseq("euazbipzncptldueeuechubrcourfpftcebikrxhybkymimgvldiwqvkszfycvqyvtiwfckexmowcxztkfyzqovbtmzpxojfofbvwnncajvrvdbvjhcrameamcfmcoxryjukhpljwszknhiypvyskmsujkuggpztltpgoczafmfelahqwjbhxtjmebnymdyxoeodqmvkxittxjnlltmoobsgzdfhismogqfpfhvqnxeuosjqqalvwhsidgiavcatjjgeztrjuoixxxoznklcxolgpuktirmduxdywwlbikaqkqajzbsjvdgjcnbtfksqhquiwnwflkldgdrqrnwmshdpykicozfowmumzeuznolmgjlltypyufpzjpuvucmesnnrwppheizkapovoloneaxpfinaontwtdqsdvzmqlgkdxlbeguackbdkftzbnynmcejtwudocemcfnuzbttcoew"));
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start) );
    }
}
