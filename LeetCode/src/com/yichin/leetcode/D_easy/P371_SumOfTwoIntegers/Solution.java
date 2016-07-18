package com.yichin.leetcode.D_easy.P371_SumOfTwoIntegers;
/*
Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

Example:
Given a = 1 and b = 2, return 3.
*/
public class Solution {
    public int getSum(int a, int b) {
        //https://leetcode.com/discuss/111565/0ms-ac-java-solution
        
        if(a==0)    return b;
        if(b==0)    return a;
        
        int sum=a^b; //加法
        int carry= (a&b)<<1; // 進位
        
        return getSum(sum, carry);
    }
}