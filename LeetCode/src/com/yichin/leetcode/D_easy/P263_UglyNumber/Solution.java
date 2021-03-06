package com.yichin.leetcode.D_easy.P263_UglyNumber;
/*
 Write a program to check whether a given number is an ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.

Note that 1 is typically treated as an ugly number.
*/

// another recursive solution: https://leetcode.com/discuss/52883/simple-java-solution-with-explanation

public class Solution {
    public boolean isUgly(int num) {
        // 2ms
        
        // special case
        if(num == 0) return false;
        while(num%2==0){
            num/=2;
        }
        while(num%3==0){
            num/=3;
        }
        while(num%5==0){
            num/=5;
        }        
        
        return num==1;
    }
}
