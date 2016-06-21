package com.yichin.leetcode.easy.P014_LongestCommonPrefix;
/*
Write a function to find the longest common prefix string amongst an array of strings.
*/
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        // edge case
        if(strs == null || strs.length ==0)   return "";
        
        String result = strs[0];
        for(int i=1; i<strs.length; i++){
            result = calCommon(result, strs[i]);
            if(result.length()==0)    return "";
        }
        
        return result;
    }
    
    String calCommon(String common, String s){
        int len = common.length() > s.length() ? s.length() : common.length();   // get short one
        
        // for i be visible outside for loop
        int i=0;
        for(; i<len;i++){
            if( !(common.charAt(i) == s.charAt(i)) ) break;
        }
        // substring(0,i) will not include i
        return s.substring(0,i);
    }
}