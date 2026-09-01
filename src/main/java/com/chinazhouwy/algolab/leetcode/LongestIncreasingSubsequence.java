package com.chinazhouwy.algolab.leetcode;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        for(int i = 0 ; i < nums.length; i ++){
            for(int j = 0 ; j < i ; j ++ ){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                    if(i == nums.length -1){
                        System.out.print(nums[j] + "  ");
                    }
                }
            }
        }
        return dp[nums.length-1];
    }


    public static void main(String[] args) {
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6}));
    }
}
