package com.yichin.leetcode.D_easy.P028_ImplementStrStr;
/*
Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
*/
public class Solution {
    public int strStr(String haystack, String needle) {
        // 直覺解
        // 2ms
        if(haystack.length() < needle.length()) return -1;
        // haystack size is 100, needle size is 9, then check (0,9)~(91,100)
        for(int i=0;i<=haystack.length()-needle.length();i++){
            if( haystack.substring(i, i+needle.length()).equals(needle) ) return i;
        }
        
        return -1;
    }
}