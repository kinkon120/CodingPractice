package com.yichin.leetcode.D_medium.P029_DivideTwoIntegers;
/*
Divide two integers without using multiplication, division and mod operator.

If it is overflow, return MAX_INT.
*/

public class Solution {
    public int divide(int dividend, int divisor) {
        // dividend/divisor
        // how about 0/0 case?
        // https://leetcode.com/discuss/57346/clean-java-solution-with-some-comment
        // 精隨在於
        // 1. 轉成long避免overflow
        // 2. 把兩者都轉成正數比較好比較
        // 3. 用binary search的方式算
        
        
        if(divisor==0)  return Integer.MAX_VALUE;
        int sign = 1;
        if( (dividend > 0 && divisor <0) || (dividend < 0 && divisor >0) ){
            sign = -1;
        }
        
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);
        
        // now both are positive
        
        long lans = ldivide(ldividend, ldivisor);
        
        if(sign == -1){
            lans = 0 - lans;    // 相當於*(-1)
        }
        
        // handle overflow
        if(lans > Integer.MAX_VALUE || lans < Integer.MIN_VALUE)    return Integer.MAX_VALUE;
        
        // general case
        return (int) lans;
    }
    
    // binary search trick
    long ldivide(long ldividend, long ldivisor){
        if (ldividend < ldivisor) return 0;
        if (ldividend ==  ldivisor) return 1;
        
        int m = 1;
        long sum = ldivisor;
        while( sum+sum < ldividend){
            sum += sum;
            m += m;
        }
        
        long rest = ldividend - sum;
        return m + ldivide(rest, ldivisor);
    }
}