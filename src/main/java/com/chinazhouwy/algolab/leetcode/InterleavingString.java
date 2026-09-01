package com.chinazhouwy.algolab.leetcode;

import java.util.Arrays;

public class InterleavingString {

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length()!= s3.length()) {
            return false;
        }

        if(s3.length() == 0){
            return true;
        }

        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        dp[0][0] = true;
        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();
        char[] s3Arr = s3.toCharArray();

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[0][0] = true;
                } else if (i == 0) {
                    dp[i][j] = (s2Arr[j-1] == s3Arr[j-1]) && dp[0][j-1];
                } else if (j == 0) {
                    dp[i][j] = (s1Arr[i-1] == s3Arr[i-1]) && dp[i-1][j];
                } else {
                    dp[i][j] = (dp[i-1][j] && (s1Arr[i-1] == s3Arr[i + j - 1]))
                            || (dp[i][j-1] && (s2Arr[j-1] == s3Arr[i + j -1]));
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        System.out.println(new InterleavingString().isInterleave(
                "aabcc",
                "dbbca",
                "aadbbcbcac"));
    }

}
