package com.yichin.leetcode.array.M059_SpiralMatrixII;
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
        
        int rowBegin=0;
        int rowEnd=n-1;
        int colBegin=0;
        int colEnd=n-1;
        
        int c = 1;
        int [][] m = new int [n][n];
        while(c <= n*n){
            for(int i=colBegin; i<=colEnd; i++){
                m[rowBegin][i]=c++;
            }
            rowBegin++;
            for(int i=rowBegin; i<=rowEnd; i++){
                m[i][colEnd]=c++;
            }
            colEnd--;
            for(int i=colEnd;i>=colBegin;i--){
                m[rowEnd][i]=c++;
            }
            rowEnd--;
            for(int i=rowEnd;i>=rowBegin;i--){
                m[i][colBegin]=c++;
            }
            colBegin++;
        }
        
        return m;
    }
}