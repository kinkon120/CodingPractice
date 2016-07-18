package com.yichin.leetcode.C_dynamicprogramming.M221_MaximalSquare;
/*
Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 4.
*/
public class Solution {
    public int maximalSquare(char[][] matrix) {
        // https://leetcode.com/discuss/45207/accepted-clean-java-dp-solution
        // DP解
        // 要畫簡易圖  為何左上角的那個element也要考慮進去
        // 19 ms
        
    	// 圖解: http://www.geeksforgeeks.org/maximum-size-sub-matrix-with-all-1s-in-a-binary-matrix/
    	
        // edge case
        if(matrix==null || matrix.length==0 || matrix[0].length==0) return 0;
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        // 多出一行是為了initialization方便, code好看
        int [][] dp = new int [m+1][n+1];
        int max=0;
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(matrix[i-1][j-1]=='1'){  // 不能用matrix[i][j]
                    // Math.min只能take兩個input...
                	// 意義其實是取左上  左  上  三個值裡面最小的
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        return max*max;
    }
}