package com.yichin.leetcode.D_easy.P290_WordPattern;

import java.util.HashMap;
import java.util.Map;

/*
Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Examples:
pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
*/
public class Solution {
    public boolean wordPattern(String pattern, String str) {
        //https://leetcode.com/discuss/62876/very-fast-3ms-java-solution-using-hashmap
        
        String [] strs = str.split(" ");
        
        if(pattern.length() != strs.length) return false;
        
        Map<Character, String> hm = new HashMap<Character, String>();
        for(int i=0;i<pattern.length();i++){
            char c = pattern.charAt(i);
            String s = strs[i];
            
            if(hm.containsKey(c)){
                if(!hm.get(c).equals(s))    return false;
            }else{
                if(hm.containsValue(s)) return false; // 避免"abba"  "dog dog dog dog"這種case --> 已經存在(a, dog), 不能再push (b, dog)
                hm.put(c,s);
            }
        }
        
        return true;
    }
}
