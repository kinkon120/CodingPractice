package com.yichin.leetcode.array.P048_RotateImage;
/*
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?
*/

public class Solution {
    public void rotate(int[][] matrix) {
        // 先做transpose (行列互換)
        // 再左右調換
        
        /*
        123                 147             741
        456 -transpose->    258 -左右調換->  852
        789                 369             963
        */
        
        // 1 ms
        
        int n = matrix.length;
        // transpose
        for(int i=0;i<n;i++){
            for(int j=i+1; j<n; j++){   // matrix[k][k]為對角線，不用動
                swap(matrix, i,j,j,i);
            }
        }
        
        // flip horizontally
        for(int i=0;i<n;i++){
            for(int j=0; j<n/2; j++){   
                swap(matrix, i,j,i,n-j-1);  // 不要忘了減一...
            }
        }        
        
    }
    
    void swap(int [][] m, int i1, int j1, int i2, int j2){
        int tmp = m[i1][j1];
        m[i1][j1] = m[i2][j2];
        m[i2][j2] = tmp;
    }
}