package com.yichin.leetcode.array.M054_SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].
*/
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
    	// https://leetcode.com/discuss/12228/super-simple-and-easy-to-understand-solution
    	// 我的精神跟上面這個相似，但實作細節不同
    	
        List<Integer> result = new ArrayList<Integer>();
        // edge case
        if(matrix==null || matrix.length==0 || matrix[0].length==0) return result;

        // row: 1
        int top = 0; 
        int bottom = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;
        
        // while不能用 left<=right && top<=bottom做條件，因為裡面每一個for可能都會終止!
        while(true){
        	// go left [top][x]
            for(int col=left;col<=right;col++)    result.add(matrix[top][col]);
            top++;
            if(top>bottom) break;
            
            // go down [x][right]            
            for(int row=top;row<=bottom;row++)    result.add(matrix[row][right]);
            right--;            
            if(left>right) break;
            
            // go right [bottom][x]
            for(int col=right;col>=left;col--)    result.add(matrix[bottom][col]);
            bottom--;
            if(top>bottom) break;
            
            // go up [x][left]
            for(int row=bottom;row>=top;row--)    result.add(matrix[row][left]);
            left++;
            if(left>right) break;
        }
        
        return result;
    }
}