package com.yichin.leetcode.C_array.E283_MoveZeroes;
/*
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
*/

public class Solution {
    public void moveZeroes(int[] nums) {
    	// total n steps, O(n)
    	        
        // move all none zero to front
        int p1=0; // write pointer
        for (int num : nums) {
            if (num != 0){
                nums[p1++] = num;
            }
        }
        
        // pad the rest number as zero
        for(int i=p1; i<nums.length ; i++){
            nums[i]=0;
        }
    }
}