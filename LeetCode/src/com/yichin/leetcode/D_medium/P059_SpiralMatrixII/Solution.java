package com.yichin.leetcode.D_medium.P059_SpiralMatrixII;
/*
Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
*/
public class Solution {
    public int[][] generateMatrix(int n) {
        // https://leetcode.com/discuss/14079/my-super-simple-solution-can-used-for-both-spiral-matrix-and
        // 記住四個角落就好了...
        
        int top=0;
        int bottom=n-1;
        int left=0;
        int right=n-1;
        
        int c = 1;
        int [][] m = new int [n][n];
        while(c <= n*n){
        	// go right
            for(int i=left; i<=right; i++){
                m[top][i]=c++;
            }
            top++;
            
            // go down
            for(int i=top; i<=bottom; i++){
                m[i][right]=c++;
            }
            right--;
            
            // go left
            for(int i=right;i>=left;i--){
                m[bottom][i]=c++;
            }
            bottom--;
            
            // go up
            for(int i=bottom;i>=top;i--){
                m[i][left]=c++;
            }
            left++;
        }
        
        return m;
    }
}