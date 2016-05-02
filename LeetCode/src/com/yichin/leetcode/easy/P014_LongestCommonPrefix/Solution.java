package com.yichin.leetcode.easy.P014_LongestCommonPrefix;
/*
Write a function to find the longest common prefix string amongst an array of strings.
*/
public class Solution {
    // 要設一個global var...
    // 如果
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
        int i=0;
        for(; i<len;i++){
            if( !(common.charAt(i) == s.charAt(i)) ) break;
        }
        return s.substring(0,i);
    }
}