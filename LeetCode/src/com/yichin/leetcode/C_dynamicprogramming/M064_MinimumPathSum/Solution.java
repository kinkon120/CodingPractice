package com.yichin.leetcode.C_dynamicprogramming.M064_MinimumPathSum;
/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
*/
public class Solution {
    public int minPathSum(int[][] grid) {
        if(grid==null || grid.length==0 || grid[0].length==0) return 0;
        
        // 我的做法跟這個一樣 https://leetcode.com/discuss/17111/my-java-solution-using-dp-and-no-extra-space
        // 4ms
        // general case:
        int row = grid.length;
        int col = grid[0].length;
        // use the same array
        
        // first row
        for(int i=1;i<col;i++){
            grid[0][i]=grid[0][i-1]+grid[0][i];
        }
        // first col
        for(int i=1;i<row;i++){
            grid[i][0]=grid[i-1][0]+grid[i][0];
        }
        
        //fill out the rest
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                grid[i][j]=grid[i][j]+ Math.min(grid[i][j-1], grid[i-1][j]);
            }
        }
        
        return grid[row-1][col-1];
    }
}