package com.chinazhouwy.algolab.leetcode;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
//        System.out.println(new LongestPalindromicSubstring().longestPalindrome("babad"));
//        System.out.println(new LongestPalindromicSubstring().longestPalindrome("ac"));
//        System.out.println(new LongestPalindromicSubstring().longestPalindrome("abb"));
//        System.out.println(new LongestPalindromicSubstring().longestPalindrome("cbbd"));
//          System.out.println(new LongestPalindromicSubstring().longestPalindrome("aacabdkacaa"));
//        System.out.println("babad".substring(0, 1));
//        String s= "aacabdkacaa";
//        System.out.println(s);
//        System.out.println(s.substring(1,s.length()-1));
//        System.out.println(s.substring(1));
//        System.out.println(s.substring(0,s.length()-1));

        System.out.println(new LongestPalindromicSubstring().longestPalindrome("ac"));

    }


    public String longestPalindrome(String s) {
        if(s.length() < 2){
            return s;
        }
        int maxLen = -1;
        int begin = -1;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i = 0;i< s.length();i++){
            dp[i][i] = true;
        }
        char[] charArray = s.toCharArray();
        for(int L = 2 ; L <= s.length();L++){
            for(int i = 0 ; i < s.length();i++){
                int j = L-2+1;
                if(j >= s.length()){
                    break;
                }
                if(charArray[i] != charArray[j]){
                    dp[i][j] = false;
                }else{
                    if(j -i < 3){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if(dp[i][j] && j -i + 1 > maxLen ){
                    maxLen = j-i +1;
                    begin = i;
                }
            }
        }
        return s.substring(begin,begin+maxLen);
    }

//    public String longestPalindrome(String s) {
//        if(s.length() == 0){
//            return "";
//        }
//        if(s.length() == 1){
//            return s;
//        }
//
//        if(s.length() == 2 && s.substring(0,1).equals(s.substring(1,2))){
//            return s;
//        }
//
//        if(s.length() == 2 && (!s.substring(0,1).equals(s.substring(1,2)))){
//            return s.substring(0,1);
//        }
//
//        if(s.length() > 2 && (s.substring(0,1).equals(s.substring(s.length()-1)))){
//            if(s.substring(1,2).equals(s.substring(s.length()-2))){
//                return s.substring(0,1)+longestPalindrome(s.substring(1,s.length()-1))+s.substring(0,1);
//            }else{
//                return longestPalindrome(s.substring(1,s.length()-1));
//            }
//        }
//
//        if(s.length() > 2 && (!s.substring(0,1).equals(s.substring(s.length()-1)))){
//            String s1 =  longestPalindrome(s.substring(1,s.length()-1));
//            String s2 =  longestPalindrome(s.substring(1));
//            String s3 =  longestPalindrome(s.substring(0,s.length()-1));
//            return compare(s1,s2,s3);
//        }
//
//        return "";
//
//    }
//
//    private String compare(String s1,String s2,String s3){
//        String s = "";
//        if (s2.length() > s1.length()) {
//            s = s2;
//        }
//        if (s3.length() > s.length()) {
//            s = s3;
//        }
//        return s;
//    }

}
