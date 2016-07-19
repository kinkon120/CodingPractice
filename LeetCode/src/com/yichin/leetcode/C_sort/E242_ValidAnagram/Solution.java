package com.yichin.leetcode.C_sort.E242_ValidAnagram;


public class Solution {
/*
Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.
*/
    public boolean isAnagram(String s, String t) {
        // naive solution: sort and then compare
        // 11ms
        /*
        if(s.length()!=t.length()) return false;    // String.length(), not String.size()
        char [] sc = s.toCharArray();
        char [] tc = t.toCharArray();
        Arrays.sort(sc);
        Arrays.sort(tc);
        
        for(int i=0;i<s.length();i++){
            if(sc[i]!=tc[i])    return false;
        }
        return true;
        	以上可用一行Arrays.equals(sChar, tChar);
        */
        
        // count character frequency
        // 6ms
        int [] count = new int [256];
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)]++;
        }
        for(int i=0;i<t.length();i++){
            count[t.charAt(i)]--;
        }
        for(int i=0;i<256;i++){
            if(count[i]!=0) return false;
        }
        return true;
        
    }
}