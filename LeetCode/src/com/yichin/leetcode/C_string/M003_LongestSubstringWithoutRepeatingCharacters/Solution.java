package com.yichin.leetcode.C_string.M003_LongestSubstringWithoutRepeatingCharacters;

import java.util.HashSet;
import java.util.Set;

/*
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/
public class Solution {
    public int lengthOfLongestSubstring(String s) {
    	// Time O(n), Space O(1)
        if(s==null || s.length()==0)  return 0;
        char [] ca = s.toCharArray();
        Set<Character> charSet = new HashSet<Character>();
        int max=0;
        int h=0; // head
        for(int t=0; t<s.length(); t++){	// t means tail            
            // 這個while很屌, 當發現ca[t]已經出現過之後, 他會從ca[h]開始往後找到c, 順便把ca[h]從set中去掉
            // 最後一次個ca[h]其實等於c, 但是在while後面會再加回來
            // 走完while之後
            // h代表的是往後都沒有出現過ca[t]這個字符
            while(charSet.contains(ca[t])) {
                charSet.remove(ca[h]);
                h++;
            }             
            charSet.add(ca[t]);
            max = Math.max(max, t-h+1);
        }
        return max;

    	
    	
    	// 以下的方法Time O(n^2)
        // edge case
        /*
        if(s==null || s.length()==0)    return 0;
        
        char [] c = s.toCharArray();
        int max = 1;
        // 計算從i開始的最長且不重複字符的字串長度
        for(int i=0;i<s.length();i++){
            Set<Character> set = new HashSet<Character>();
            for(int j=i;j<s.length();j++){
                if(set.contains(c[j])){
                    break;
                }else{
                    set.add(c[j]);
                }
            }
            if(set.size() > max) max = set.size();
        }
        return max;
        */
    }
}