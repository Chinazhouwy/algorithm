package com.Chinazhouwy.leetcode;


import java.util.Arrays;

public class Solution322 {
//    public int coinChange(int[] coins, int amount) {
//        int[] dp = new int[amount+1];
//        for(int i= amount ; i > 0  ; i --){
//            for(int j = 0 ; j < coins.length; j++){
//                dp[i] =  Math.min(dp[i] ,dp[i-coins[j]])+1;
//            }
//        }
//        return dp[amount];
//    }


    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount + 1);
        dp[0] = 0;
        Arrays.sort(coins);
        for(int i= 1 ; i <= amount ; i ++){
            for(int j = 0 ; j < coins.length && (coins[j] <= i); j++){
                dp[i] =  Math.min(dp[i] ,dp[i-coins[j]])+1;
            }
        }
        return dp[amount] >= amount + 1 ? -1 : dp[amount];
    }

    public int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount + 1);
        dp[0] = 0;
//        Arrays.sort(coins);
        for(int i= 1 ; i <= amount ; i ++){
            for(int j = 0 ; j < coins.length && (coins[j] <= i); j++){
                dp[i] =  Math.min(dp[i] ,dp[i-coins[j]]+1);
            }
        }
        return dp[amount] >= amount + 1 ? -1 : dp[amount];
    }


    public static void main(String[] args) {
//        System.out.println(new Solution322().coinChange(new int[]{1,2,5}, 11));
//        System.out.println(new Solution322().coinChange(new int[]{2}, 3));
//        System.out.println(new Solution322().coinChange(new int[]{2,5,10,1}, 27));
        System.out.println(new Solution322().coinChange2(new int[]{474,83,404,3}, 264));
    }

}
