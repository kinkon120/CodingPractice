package com.yichin.leetcode.C_hashtable.E205_IsomorphicStrings;
/*
Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.
*/

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        // https://leetcode.com/discuss/33854/my-6-lines-solution
        // 用char map
        // 15ms
        
        if(s.length() != t.length())    return false;
        int [] sc = new int [256];
        int [] tc = new int [256];
        
        for(int i=0; i< s.length(); i++){   // s.length(), 不是s.length
            if(sc[s.charAt(i)] != tc[t.charAt(i)])    return false;
            // 記住每個char每次出現的最後位置
            sc[s.charAt(i)] = i+1;  // 如果只是用i, 則第一個char的影響不會被考慮到, 實際上+2 or +k都可以
            tc[t.charAt(i)] = i+1;
        }
        return true;        
        
        
        // 26ms hashmap
        /*
        if(s.length() != t.length())    return false;
        
        char [] sc = s.toCharArray();
        char [] tc = t.toCharArray();
        
        Map<Character, Character> map = new HashMap<Character, Character>();
        Map<Character, Character> map1 = new HashMap<Character, Character>();
        
        for(int i=0; i< sc.length; i++){
            if(map.get(sc[i])==null){
                map.put(sc[i],tc[i]);   // 要考慮到兩個sc[i] map到同一個tc[i]的case
            }else{
                if(map.get(sc[i])!=tc[i])   return false;
            }
            
            if(map1.get(tc[i])==null){
                map1.put(tc[i],sc[i]);   // 要考慮到兩個sc[i] map到同一個tc[i]的case, 所以要做兩次
            }else{
                if(map1.get(tc[i])!=sc[i])   return false;
            }
        }
        
        return true;
        */
    }
}