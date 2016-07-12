package com.yichin.leetcode.easy.P342_PowerOfFour;
/*
Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

Example:
Given num = 16, return true. Given num = 5, return false.

Follow up: Could you solve it without loops/recursion?
*/
public class Solution {
    public boolean isPowerOfFour(int num) {
        // 跟power of three一樣
        
        // edge condition
        if(num == 1) return true;
        if(num < 4) return false;
        
        /*  while solution
        while(num!=1){
            if(num%4 != 0)    return false;
            num/=4;
        }
        return true;
        */
        
        // 數學解
        // http://www.programcreek.com/2015/04/leetcode-power-of-four-java/
        int degree = (int) (Math.log(num)/Math.log(4));// 要轉型成int...
        
        return Math.pow(4, degree) == num;
    }
}