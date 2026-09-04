package com.chinazhouwy.algolab.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.sql.DriverManager;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class JewelsAndStones {

    @Test
    public void test(){
        String J = "aA", S = "aAAbbbb" ;
        Assert.assertEquals(3,numJewelsInStones(J,S));

        J = "z";
        S = "ZZ";
        Assert.assertEquals(0,numJewelsInStones(J,S));
        //DriverManager.getConnection()
    }

    public static int numJewelsInStones(String J, String S) {

        char[] chars = S.toCharArray();

        Map<Character,Integer> map = new HashMap<>();

        for(char c : chars){
            map.put(c,((Integer) map.getOrDefault(c,0))+1);
        }

        char[] chars1 = J.toCharArray();

        Integer sum = 0;

        for(char c : chars1){
            sum += map.getOrDefault(c,0);
        }

        return sum;

    }

    public static void main( String[] args ){
        String[] srcStr = new String[]{
                "a","b","c","d"
        };

        String[] descStr = new String[srcStr.length];

        System.arraycopy(srcStr,0,descStr,0,srcStr.length);

        System.out.println(Arrays.asList(descStr));

    }
}
