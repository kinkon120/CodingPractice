package com.yichin.leetcode.C_dynamicprogramming.M279_PerfectSquares;
/*
Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.


*/
public class Solution {
    public int numSquares(int n) {
        // https://leetcode.com/discuss/62526/an-easy-understanding-dp-solution-in-java
        // DP解
        int [] dp = new int [n+1];
        dp[0]=0;
        for(int i=1;i<=n;i++){
            int min = Integer.MAX_VALUE;
            int j=1;
            while(i>=j*j){
                int x = dp[i-j*j]+1;    // 一開始我用了try當變數名, 但try是reserved word...不能當變數
                min = Math.min(min, x);
                j++;
            }
            dp[i]=min;
        }
        return dp[n];
    }
}