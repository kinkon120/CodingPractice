package com.yichin.leetcode.array.P074_SearchA2DMatrix;
/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.


*/
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 從最右上開始, 當前元素小就往下, 當前元素大就往左
        // Ex: 要找13
        // 7(小)->20(大)->16(大)->11(小)->30(大)->23(大)  想往左卻越界了
        // Ex: 要找100
        // 7(小)->20(小)->50(小)->越界...
        
        
        if(matrix==null || matrix.length==0 || matrix[0].length==0) return false;
        
        int i=0;
        int j=matrix[0].length-1;
        while(i<=matrix.length-1 && j>=0){
            if(matrix[i][j] == target)  return true;
            else if(matrix[i][j] > target)  j--;
            else i++;
        }
        // out of bound
        return false;
    }
}