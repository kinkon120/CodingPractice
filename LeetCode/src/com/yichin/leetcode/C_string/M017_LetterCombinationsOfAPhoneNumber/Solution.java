package com.yichin.leetcode.C_string.M017_LetterCombinationsOfAPhoneNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
*/
public class Solution {
    // construct map
    static Map<Integer, Character []> hm;
    static {
        hm = new HashMap<Integer, Character []>();
        hm.put(2, new Character [] {'a', 'b', 'c'});
        hm.put(3, new Character [] {'d', 'e', 'f'});
        hm.put(4, new Character [] {'g', 'h', 'i'});
        hm.put(5, new Character [] {'j', 'k', 'l'});
        hm.put(6, new Character [] {'m', 'n', 'o'});
        hm.put(7, new Character [] {'p', 'q', 'r', 's'});
        hm.put(8, new Character [] {'t', 'u', 'v'});
        hm.put(9, new Character [] {'w', 'x', 'y', 'z'});
        
    }
    
    
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        // edge case
        if (digits==null || digits.length()==0)   return result;
        // 這部分要問清楚定義... 如果是空字串要回傳啥?
        
        // initial set
        result.add("");
        
        for(int i=0;i<digits.length();i++){
            List<String> tmp = new ArrayList<String>();    
            for(String str : result){
                int k = digits.charAt(i) - '0';
                for(char nc : hm.get(k)){
                    tmp.add(str+nc);
                }
            }
            result = tmp;
        }
        return result;
    }
    

}