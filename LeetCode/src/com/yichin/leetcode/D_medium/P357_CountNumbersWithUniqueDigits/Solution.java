package com.yichin.leetcode.D_medium.P357_CountNumbersWithUniqueDigits;
/*
Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10^n.

Example:
Given n = 2, return 91. (The answer should be the total numbers in the range of 0 ≤ x < 100, excluding [11,22,33,44,55,66,77,88,99])

Show Hint 

*/
public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        // 先列舉...
        // n=1: 0~9都是  10
        // n=2: 比n=1時多了10~99共90個數字, 扣掉11~99共九個, 10+81=91, 81怎麼來的? 9(1~9)*9(0~9扣掉前一個數)
        // n=3: 比n=2時多了100~999共900個數字, 會多出 9*9*8(扣掉前兩個數字)
        // n=4: 會多出9*9*8*7
        // ....
        
        // edge case
        if(n==0)    return 1;
        
        int result = 10;
        if(n==1)    return result;
        for(int i=2;i<=n;i++){
            if(i>=10)   break;
            
            int newAdd = 9*9;
            for(int j=2;j<i;j++){
                // when i=3, 最後一個j=2, newAdd*8
                newAdd = newAdd * (10-j);
            }
            result += newAdd; 
        }
        return result;
    }
}