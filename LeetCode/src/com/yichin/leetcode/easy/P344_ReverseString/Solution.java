package com.yichin.leetcode.easy.P344_ReverseString;

/*
Write a function that takes a string as input and returns the string reversed.

Example:
Given s = "hello", return "olleh".
 */
public class Solution {
    public String reverseString(String str) {
        if(str==null || str.length()<=1)    return str;
        
        char [] ca = str.toCharArray();
        int s=0, e=str.length()-1;
        while(s<e){
            char tmp = ca[s];
            ca[s] = ca[e];
            ca[e] = tmp;
            s++;
            e--;
        }
        StringBuilder sb = new StringBuilder();
        for(char c : ca){
            sb.append(c);
        }
        return sb.toString();
    }
}