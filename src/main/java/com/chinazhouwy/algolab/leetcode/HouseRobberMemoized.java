package com.chinazhouwy.algolab.leetcode;

import java.util.HashMap;
import java.util.Map;

class HouseRobberMemoized {

    private static Map<Integer,Integer> map = new HashMap<>();

    public int rob(int[] nums) {

        if(map.get(nums.length) != null){
            return map.get(nums.length);
        }

        if(nums.length == 1){
            return nums[0];
        }

        if(nums.length == 2){
            return nums[0] > nums[1] ? nums[0] : nums[1];
        }

        if(nums.length > 2){
            int res =
                    Math.max(
                            rob(copyOfrange(nums,0, nums.length -2)),
                            rob(copyOfrange(nums,0, nums.length -3))+ nums[nums.length-1]);
            map.put(nums.length,res);
            return map.get(nums.length);
        }

        return -1;
    }

    private int[] copyOfrange(int[] nums, int start , int end ){
        int[] newArr = new int[end -start + 1];
        for(int i =start;i<= end ;i ++){
            newArr[i] = nums[i];
        }
        return newArr;
    }


    public static void main(String[] args) {
        System.out.println(new HouseRobberMemoized().rob(new int[]{2, 7, 9, 3, 1}));
    }

}
