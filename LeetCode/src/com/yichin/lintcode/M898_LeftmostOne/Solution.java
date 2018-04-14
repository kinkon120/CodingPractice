package com.yichin.lintcode.M898_LeftmostOne;
public class Solution {
    /**
     * @param arr: The 2-dimension array
     * @return: Return the column the leftmost one is located
     */
    public int getColumn(int[][] arr) {
        /*
            Given a 2D array, and each line has only 0 and 1, the front part is 0, and the latter part is 1. Find
            the number of columns in the leftmost 1 of all the rows in the array.

            Example
            Given arr = [[0,0,0,1],[1,1,1,1]], return 0.
            Explanation:
            Arr[1][0] is the leftmost 1 in all rows and its column is 0.
            
            Given arr = [[0,0,0,1],[0,1,1,1]], return 1.
            Explanation:
            Arr[1][1] is the leftmost 1 in all rows and its column is 1.
            
                       簡單講就是找哪欄最先有1
            
            What if 都沒有??  Return 0;
        */
        
        // edge case
        if(arr == null || arr.length==0 || arr[0].length==0)    return 0;
        
        for(int col=0 ; col<arr[0].length ; col++) {
            for(int row=0 ; row<arr.length ; row++) {
                if(arr[row][col] == 1) return col;
            }
        }
        return 0;
    }
}