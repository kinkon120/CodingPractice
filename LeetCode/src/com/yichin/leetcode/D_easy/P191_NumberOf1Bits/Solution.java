package com.yichin.leetcode.D_easy.P191_NumberOf1Bits;
/*
Write a function that takes an unsigned integer and returns the number of 』1' bits it has (also known as the Hamming weight).

For example, the 32-bit integer 』11' has binary representation 00000000000000000000000000001011, so the function should return 3.

*/
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int result = 0;
        while(n!=0){
            if((n&1)==1){
                result++;
            }
            n = n>>>1; // need to do unsigned shift....
        }
        return result;
        
        
        /* 字串解, 有點白癡....
        String integer = Integer.toBinaryString(n);
        integer = integer.replaceAll("0","");
        return integer.length();
        */
    }
}
