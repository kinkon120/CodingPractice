package com.yichin.leetcode.D_easy.P231_PowerOfTwo;
/*
Given an integer, write a function to determine if it is a power of two.
*/

public class Solution {
    public boolean isPowerOfTwo(int n) {
        // 得先問-16這種算不算power of two...結論是不算...
        // https://leetcode.com/discuss/43875/using-n%26-n-1-trick
        if(n<=0)    return false;
        if( (n&(n-1)) == 0) return true; // 要用對括號!!   
        return false;
        
        /*
        // 2ms, 自己想的方法
        if(n<=0)    return false;
        while(n!=1){
            if(n%2==1)  return false;
            n>>=1; // unsigned right shift
        }
        return true;
        */
    }
}