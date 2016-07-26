package com.yichin.leetcode.D_medium.P279_PerfectSquares;
/*
Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.


*/
public class Solution {
    public int numSquares(int n) {
        // https://leetcode.com/discuss/62526/an-easy-understanding-dp-solution-in-java
    	/*
			dp[0] = 0 
			dp[1] = dp[0]+1 = 1
			dp[2] = dp[1]+1 = 2
			dp[3] = dp[2]+1 = 3
			dp[4] = Min{ dp[4-1*1]+1, dp[4-2*2]+1 } 
			      = Min{ dp[3]+1, dp[0]+1 } 
			      = 1				
			dp[5] = Min{ dp[5-1*1]+1, dp[5-2*2]+1 } 
			      = Min{ dp[4]+1, dp[1]+1 } 
			      = 2
									.
									.
									.
			dp[13] = Min{ dp[13-1*1]+1, dp[13-2*2]+1, dp[13-3*3]+1 } 
			       = Min{ dp[12]+1, dp[9]+1, dp[4]+1 } 
			       = 2
									.
									.
									.
			dp[n] = Min{ dp[n - i*i] + 1 },  n - i*i >=0 && i >= 1
    	 */
        // DP解
        int [] dp = new int [n+1];
        dp[0]=0;
        for(int i=1;i<=n;i++){
            int min = Integer.MAX_VALUE;
            int j=1;
            while(i>=j*j){
                int x = dp[i-j*j]+1;    // 一開始我用了try當變數名, 但try是reserved word...不能當變數
                // 意義是i可以試著用 i-j*j + j*j的方式組成
                // dp[i-j*j]已保證是最佳解
                // +1的意思是多用了一個j*j這個perfect square number
                min = Math.min(min, x);
                j++;
            }
            dp[i]=min;
        }
        return dp[n];
    }
}