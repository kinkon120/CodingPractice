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
        // rules:前面的字母代表數字比較小的話, 把前面字母的數字減兩遍
        //eg：III=3,IV=4,VI=6,XIX=19,XX=20,XLV=45
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
        
        int result = 0;
        int pre = 0;
        for(char c : s.toCharArray()) {
            int cur = map.get(c);
            result += cur;
            if(pre < cur) result -= pre*2;	// 前面的字母代表數字比較小的話, 把前面字母的數字減兩遍
            // Ex: IV, 讀到I的時候會先加1, 但讀到V(5)時, V>I, 所以要把I代表的數字1減兩次
            // 當讀到I時, pre為0, 扣兩次沒影響
            pre = cur;
        }
        return result;
    }
}