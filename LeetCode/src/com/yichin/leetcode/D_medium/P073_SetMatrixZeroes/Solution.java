package com.yichin.leetcode.D_medium.P073_SetMatrixZeroes;
/*
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

click to show follow up.

Follow up:
Did you use extra space?
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
*/

public class Solution {
    public void setZeroes(int[][] matrix) {
        // http://www.lifeincode.net/programming/leetcode-set-matrix-zeroes-java/
        // O(1)的方法-> 把第一列跟第一欄拿來記錄用
        // 用第0行和第0列來記錄第1 ~ m-1行和第1 ~ n-1列是否需要置0。而用兩個變量記錄第0行和第0列是否需要置0。
        // 跟這個一樣 https://leetcode.com/discuss/38186/my-ac-java-o-1-solution-easy-to-read
        
        int m = matrix.length;
        int n = matrix[0].length;
        boolean firstRowZero = false;
        boolean firstColZero = false;
        
        // 決定第一行是否要全設0
        for(int i=0;i<n;i++){
            if(matrix[0][i]==0){
                firstRowZero = true;
                break;
            }
        }
        
        // 決定第一行是否要全設0
        for(int i=0;i<m;i++){
            if(matrix[i][0]==0){
                firstColZero = true;
                break;
            }
        }
        
        //用第一欄跟第一列存設0的資訊
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j]==0){
                    matrix[0][j]=0;
                    matrix[i][0]=0;
                }
            }
        }
        
        //設0
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[0][j]==0 || matrix[i][0]==0){
                    matrix[i][j]=0;
                }
            }
        }        
        
        //回頭check第一行跟第一列
        if(firstRowZero){
            for(int i=0;i<n;i++){
                matrix[0][i]=0;
            }
        }
        
        if(firstColZero){
            for(int i=0;i<m;i++){
                matrix[i][0]=0;
            }
        }        
        /*
        // O(m+n)
        boolean [] row = new boolean [matrix.length];
        boolean [] col = new boolean [matrix[0].length];
        for(int i=0; i<matrix.length;i++){
            for(int j=0; j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    row[i]=true;
                    col[j]=true;
                }
            }            
        }
        
        for(int i=0; i<matrix.length;i++){
            for(int j=0; j<matrix[0].length;j++){
                if(row[i] || col[j])    matrix[i][j]=0;
            }            
        }        
        */
    }
}
