package com.yichin.leetcode.C_math.E007_ReverseInteger;
/*
Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321
*/
public class Solution {
    public int reverse(int x) {
        // 陷阱是overflow...
        int y=0;
        while(x!=0){
            // check overflow
        	// check current value of y, if we can't go further, then just stop
            if(y > Integer.MAX_VALUE/10 || y < Integer.MIN_VALUE/10)   return 0;
            
            y=y*10+x%10;
            x/=10;
        }
        
        return y;
    }
}