package com.yichin.leetcode.medium.P201_BitwiseANDOfNumbersRange;
/*
Given a range [m, n] where 0 <= m <= n <= 2147483647, 
return the bitwise AND of all numbers in this range, inclusive.

For example, given the range [5, 7], you should return 4.
*/

public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        // https://leetcode.com/discuss/32017/my-simple-java-solution-3-lines
        // find the leftmost common digits of m and n.
        int r=Integer.MAX_VALUE;
        while( (m&r) != (n&r) )  r=r<<1;    //最後希望達到111110000這種形式
        return m&r;
        
        // 暴力法果然過不了
        /*
        int k = Integer.MAX_VALUE;
        for(int i=m; i<=n;i++){
            k &= i;
        }
        return k;
        */
    }
}