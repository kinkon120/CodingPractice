package com.yichin.leetcode.math.E326_PowerOfThree;
/*
Given an integer, write a function to determine if it is a power of three.

Follow up:
Could you do it without using any loop / recursion?
*/
public class Solution {
    public boolean isPowerOfThree(int n) {
        // edge case
        if(n==0)    return false;
        
        
        // naive solution
        /*
        while(n!=1){
            if(n%3 != 0)    return false;
            n=n/3;
        }
        return true;
        */
        
        // https://leetcode.com/discuss/78532/summary-all-solutions-new-method-included-at-15-30pm-jan-8th
        // 不用while or recursion就只能是數學解
        
        int maxPowerOfThree = (int)Math.pow(3, (int)(Math.log(0x7fffffff) / Math.log(3)));
        return n>0 && maxPowerOfThree%n==0;
    }
}