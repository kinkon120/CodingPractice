package com.yichin.leetcode.math.M012_IntegerToRoman;
/*
Given an integer, convert it to a roman numeral.
Input is guaranteed to be within the range from 1 to 3999.

I:1
V:5
X:10
L:50
C:100
D:500
M:1000

XI:11
IX:9
VI:6
IV:4
*/


public class Solution {
    public String intToRoman(int num) {
        // https://leetcode.com/discuss/1208/how-to-improve-code
        // 11 ms
        // 把每一個位數可能的都列出來...
        String [] thousands = new String [] {"", "M", "MM", "MMM"};
        String [] hundreds = new String [] {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String [] tens = new String [] {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String [] ones = new String [] {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        
        return thousands[num/1000]+hundreds[(num%1000)/100]+tens[(num%100)/10]+ones[num%10];
    }
}