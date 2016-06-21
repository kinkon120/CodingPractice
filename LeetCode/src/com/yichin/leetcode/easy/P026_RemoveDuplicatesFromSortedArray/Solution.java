package com.yichin.leetcode.easy.P026_RemoveDuplicatesFromSortedArray;
/*
Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. 
It doesn't matter what you leave beyond the new length.


*/
public class Solution {
    public int removeDuplicates(int[] nums) {
        // 就是直接硬幹...
        // https://leetcode.com/discuss/10314/my-solution-time-o-n-space-o-1
        // 1ms
        
        if(nums==null || nums.length==0)  return 0;
        if(nums.length==1)   return nums.length;
        
        
        // 1 2 2 2 3 3
        // -> 1 2 3
        int ind=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1] != nums[i]){
                nums[ind++]=nums[i];
            }
        }
        // 不用做ind--, 看一下範例
        // 因為一開始的index是0
        return ind;
    }
}