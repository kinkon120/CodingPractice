package com.yichin.leetcode.C_math.E013_RomanToInteger;

import java.util.HashMap;
import java.util.Map;
/*
Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.
*/

public class Solution {
    public int romanToInt(String s) {
        // Def http://literacy.kent.edu/Minigrants/Cinci/romanchart.htm
        // I:1, V:5
        // X:10, L:50
        // C:100, D:500
        // M:1000
        // IV: 4, XL: 40, IX: 9
        // 1954 as MCMLIV
        
        // https://leetcode.com/discuss/42582/my-java-solution
        // rules:位於大數的後面時就作為加數；位於大數的前面就作為減數
        //eg：III=3,IV=4,VI6,XIX=19,XX=20,XLV=45
        // 18ms

        // build hashmap
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        
        char [] cs = s.toCharArray();
        // 最後一個digit沒有跟班, 先考慮進來
        int result = map.get(cs[cs.length-1]);
        for(int i=0 ; i<cs.length-1 ; i++){
            char c1 = cs[i];
            char c2 = cs[i+1];
            // 跟後面的比
            int cur = map.get(c1);
            int behind = map.get(c2);
            if(cur >= behind){ 
            	// Ex:VI is 6, II is 2
                result += cur;
            }else{  
            	// Ex: IV is 4
                result -= cur;
            }
        }
        return result;
        
    }
}