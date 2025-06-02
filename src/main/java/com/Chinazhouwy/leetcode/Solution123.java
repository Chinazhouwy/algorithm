package com.Chinazhouwy.leetcode;

public class Solution123 {

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][5];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0; //第二次买入，，持有
        dp[0][3] = -prices[0]; //第二次卖出，，不持有
        dp[0][4] = 0;
        for(int i = 1;i< prices.length;i++){
            dp[i][0] = dp[i-1][0];
            dp[i][1] = Math.max(dp[i-1][0] -prices[i],dp[i-1][1]);
            dp[i][2] = Math.max(dp[i-1][1] + prices[i],dp[i-1][2]);
            dp[i][3] = Math.max(dp[i-1][2] - prices[i],dp[i-1][3]);
            dp[i][4] = Math.max(dp[i-1][3] + prices[i],dp[i-1][4]);
        }

        int max = -1;
        for(int i= 0 ; i<5;i++){
            if(dp[prices.length-1][i] > max) {
                max = dp[prices.length-1][i];
            }
        }

        return  max;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution123().maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
        System.out.println(new Solution123().maxProfit(new int[]{1,2,3,4,5}));
    }

}
