package com.yichin.leetcode.C_array.E027_RemoveElement;
/*
Given an array and a value, remove all instances of that value in place and return the new length.
The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Given nums = [3,2,2,3], val = 3,

Your function should return length = 2, with the first two elements of nums being 2.
*/

public class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums==null || nums.length==0) return 0;
        
        //https://leetcode.com/discuss/3753/my-solution-for-your-reference
        // in place modification
        // 1 2 2 2 2 3 2 4 6, val =2
        // result 1 3 4 6 || 2 3 2 4 6
        // begin value 為4
        
        /*
         * 原本有疑慮說nums[5]的3會被overwrite，
         * 但其實不會
         * 因為3已經被放到nums[1]的位子去了
         * 提前卡位
         * */
        int begin=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[begin++] = nums[i];
            }
        }
        
        return begin;
    }
}