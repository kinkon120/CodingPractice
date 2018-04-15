package com.yichin.leetcode.D_medium.P153_FindMinimumInRotatedSortedArray;


/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.
*/
public class Solution {
    public int findMin(int[] nums) {
        // https://leetcode.com/discuss/16260/java-solution-with-binary-search
        if(nums==null || nums.length==0)    return 0;
        
        int s=0;
        int e=nums.length-1;        
        while( s<e ){
            int m=(s+e)/2;
            if(nums[m] > nums[e]){ // mid要跟end比, 不是跟start比, 不然0123456的case會走錯邊...
                s=m+1;
            }else{
                e=m;
            }
        }
        
        // 用不同範例套用多走幾次
        // 1234567
        // 2345671
        // 6712345
        // 4567123        
         
        return nums[e];
    }
}
