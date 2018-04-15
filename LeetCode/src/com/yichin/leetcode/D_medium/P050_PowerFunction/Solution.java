package com.yichin.leetcode.D_medium.P050_PowerFunction;
/*
Implement pow(x, n).
x^n;
*/
public class Solution {
    public double myPow(double x, int n) {
        if(n==0)    return (double)1;
        if(n==1)    return x;
        
        // 要考慮負數...
        boolean isNegative = false;
        if(n<0){
            isNegative = true;
            n *= -1;
        }    
        
        // log n trick
        double result = myPow(x,n/2);
        result *= result;
        if(n%2==1)  result*=x;
        
        if(isNegative) result = 1/result;
        return result;
    }
}
