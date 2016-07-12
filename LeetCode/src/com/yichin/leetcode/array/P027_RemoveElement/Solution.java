package com.yichin.leetcode.array.P027_RemoveElement;
/*
Given an array and a value, remove all instances of that value in place and return the new length.
The order of elements can be changed. It doesn't matter what you leave beyond the new length.
*/

public class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums==null || nums.length==0) return 0;
        
        //https://leetcode.com/discuss/3753/my-solution-for-your-reference
        // in place modification
        // 1 2 2 2 2 3 2 4 6, val =2
        // result 1 3 4 6 || 2 3 2 4 6
        // begin value 為4
        int begin=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[begin++] = nums[i];
            }
        }
        
        return begin;
    }
}