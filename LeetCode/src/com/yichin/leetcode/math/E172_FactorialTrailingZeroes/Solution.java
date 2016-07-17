package com.yichin.leetcode.math.E172_FactorialTrailingZeroes;
/*
Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity
*/

public class Solution {
    public int trailingZeroes(int n) {
        // 只要有一個5就會有一個0
        // 但要考慮 5^k的狀況
    	// 簡單講  考慮有多少個5的因數
        
        // n=20 -> 4
        // n=26 -> 6
        // n=133 -> 130/5=26, 130/25=5, 130/125=1;
        
        // https://leetcode.com/discuss/19855/my-one-line-solutions-in-3-languages
        // recursive
        // 2 ms
        //return n==0 ? 0 : n/5 + trailingZeroes(n/5);
        
        // https://leetcode.com/discuss/20691/my-explanation-of-the-log-n-solution
        // readable
        // 2 ms
        
        int cnt=0;
        while(n!=0){
            cnt += n/5;
            n/=5;
        }
        return cnt;
        
        
        // 我的寫法, 會超時 =_=
        /*
        int result=0;
        int base=5;
        while(n/base!=0){
            result += n/base;
            base*=5;
        }
        return result;
        */
    }
}