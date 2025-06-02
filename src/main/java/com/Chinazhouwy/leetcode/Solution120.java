package com.chinazhouwy.leetcode;

import java.util.*;

public class Solution120 {

    Map<String, Integer> map = new HashMap<>();

    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int[][] dp = new int[row][row];
        dp[0][0] = triangle.get(0).get(0);
        int minPath = Integer.MAX_VALUE;

        // for (int i = row - 1; i > 0; i--) {
        for (int j = 0; j < row; j++) {
            getDp(row-1, j, dp, triangle);
        }
        // }

        for (int i = 0; i < triangle.get(row - 1).size(); i++) {
            minPath = Math.min(minPath, dp[row - 1][i]);
        }

        return minPath;
    }

    private int getDp(int i, int j, int[][] dp, List<List<Integer>> triangle) {
        int ret = -1;
        if (i < 0 || j < 0 || i < j) {
            ret = Integer.MAX_VALUE;
        } else if (i == 0 && j == 0) {
            ret = dp[0][0];
        } else {
             if (map.get(i+""+j) != null) {
                 return map.get(i+""+j);
             }
            ret = Math.min(getDp(i - 1, j, dp, triangle), getDp(i - 1, j - 1, dp, triangle)) + triangle.get(i).get(j);
             System.out.println(i + " " + j + " "+ret);
             map.put(i+""+j, ret);
            dp[i][j] = ret;
        }
        System.out.println(i + " " + j + " "+ret);
        return ret;
    }

    public static void main(String[] args) {
        List<Integer> arr1 = Arrays.asList(2);
        List<Integer> arr2 = Arrays.asList(3,4);
        List<Integer> arr3 = Arrays.asList(6,5,7);
        List<Integer> arr4 = Arrays.asList(4,1,8,3);
        List<List<Integer>> triangle = Arrays.asList(arr1,arr2,arr3,arr4);
        System.out.println(new Solution120().minimumTotal(triangle));
    }

}
