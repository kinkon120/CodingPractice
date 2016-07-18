package com.yichin.leetcode.C_hashtable.M003_LongestSubstringWithoutRepeatingCharacters;

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
        // edge case
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
    }
}