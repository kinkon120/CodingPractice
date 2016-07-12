package com.yichin.leetcode.array.P062_UniquePaths;
/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?
*/
public class Solution {
    public int uniquePaths(int m, int n) {
        // DP... x[i][j]紀錄到目前的走法數目
        // 1 ms
        // 要注意row 0 and column 0 代表的是m=1 跟 n=1的狀況
        
        if(m==0 || n==0) return 0;

        int [][] p = new int [m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 || j==0){
                    p[i][j]=1; //row 0 or col 0
                }else{
                    p[i][j]=p[i-1][j]+p[i][j-1];
                }
            }
        }
        
        return p[m-1][n-1];
    }
}