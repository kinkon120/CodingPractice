package com.yichin.leetcode.D_medium.P378_KthSmallestElementInASortedMatrix;

/*Given a n x n matrix where each of the rows and columns are sorted in ascending order, 
find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,
return 13.
*/

public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
    	// https://discuss.leetcode.com/topic/52948/share-my-thoughts-and-clean-java-code
    	// 在比較的時候用min heap
    	// space: O(row)
    	// time: O(k lg row)
    	// min heap需要自己定義tuple以及comparableTo function
    	// 每個tuple要存三個數字, row, col, and value
    	
    	// 自己寫的
        // 每一排都是sorted
        // 用 int [] ind 存目前最小的數
                
        int [] index = new int [matrix.length];
        int result = Integer.MAX_VALUE;
        while(k!=0){
            
            int curMin = Integer.MAX_VALUE;
            int minInd = Integer.MAX_VALUE;
            // find the smallest number from all rows
            for(int i=0; i<index.length;i++){
                int indexOfThisRow = index[i];
                if(indexOfThisRow!=-1 && matrix[i][indexOfThisRow] < curMin){
                    curMin = matrix[i][index[i]];
                    minInd = i;
                }
            }
            
            // update index
            if(index[minInd]==matrix.length-1){
                // last element already
                index[minInd]=-1; // never check this row again
            }else{
                index[minInd]++;
            }
            result = curMin;
            k--;
        }
        return result;
    }
}