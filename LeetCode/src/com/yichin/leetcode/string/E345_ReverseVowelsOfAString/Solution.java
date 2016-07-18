package com.yichin.leetcode.string.E345_ReverseVowelsOfAString;
/*
Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:
Given s = "hello", return "holle".

Example 2:
Given s = "leetcode", return "leotcede".
*/
public class Solution {
    public String reverseVowels(String str) {
        if(str==null || str.length()==0) return str;
        
        char [] ca = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        int s=0, e=ca.length-1;
        while( true /*&& s<ca.length && e>=0*/){
            while(s<ca.length && !isVowel(ca[s])){ // index check要早於isVowel check
                s++;
            }
            while(e>=0 && !isVowel(ca[e])){
                e--;
            }
            
            if(s>e) break;
            else{
                swap(ca, s, e);
                s++;
                e--;
            }
        }
        
        for(char c : ca){
            sb.append(c);
        }
        return sb.toString();
    }
    
    void swap(char [] ca, int i, int j){
        char tmp = ca[i];
        ca[i] = ca[j];
        ca[j] = tmp;
    }
    
    boolean isVowel(char c){
        // 大小寫都要考慮啦...
        if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u') return true;
        if(c=='A' || c=='E' || c=='I' || c=='O' || c=='U') return true;
        return false;
    }
}