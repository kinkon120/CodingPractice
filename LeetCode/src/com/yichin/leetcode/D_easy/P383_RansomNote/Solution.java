package com.yichin.leetcode.D_easy.P383_RansomNote;
/*
Given an arbitrary ransom note string and another string containing letters from all the magazines, 
write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false. 

Each letter in the magazine string can only be used once in your ransom note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true

*/
public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // https://discuss.leetcode.com/topic/53864/java-o-n-solution-easy-to-understand
        // 基本上就是數每個字母出現的次數而以
        // ransomNote的字母要可以從magazine裡面找到
        
        int [] cnt = new int [26];
        char [] r = ransomNote.toCharArray();
        char [] m = magazine.toCharArray();
        for(int i=0;i<m.length;i++){
            int k = m[i]-'a';
            cnt[k]++;
        }
        
        for(int i=0;i<r.length;i++){
            int k = r[i]-'a';
            if(cnt[k]==0)   return false;
            else cnt[k]--;
        }
        
        return true;
    }
}