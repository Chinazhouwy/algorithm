package com.Chinazhouwy.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution139 {

    Set<String> set = new HashSet<>();

    public boolean wordBreak(String s, List<String> wordDict) {
            if(set.contains(s)){
                return false;
            }
            if(s.length() == 0){
                return true;
            }
            for (int j = 0; j < wordDict.size(); j++) {
                if (s.startsWith(wordDict.get(j))) {
                    if(wordBreak(s.substring(wordDict.get(j).length()),wordDict)){
                        return true;
                    }else{
                        set.add(s);
                    }
                }
            }
            return false;
    }


    public boolean wordBreak2(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()];

        if(dp[s.length()-1]){
            return true;
        }
        if(s.length() == 0){
            return true;
        }

        for(int i = 0; i< s.length(); i ++){
            for (int j = 0; j < wordDict.size(); j++) {
                if (s.startsWith(wordDict.get(j))) {
                    if(wordBreak(s.substring(wordDict.get(j).length()),wordDict)){
                        dp[i] = true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution139().wordBreak(" ",
//                Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa")));
        System.out.println(new Solution139().wordBreak2("leetcode", Arrays.asList("leet","code")));
    }

}
