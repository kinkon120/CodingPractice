package com.yichin.leetcode.C_binarysearch.M162_FindPeakElement;


/*
A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

Note:
Your solution should be in logarithmic complexity.
*/

public class Solution {
    int helper (int [] n, int s, int e){
        if(s==e)    return e;
        int mid=(s+e)/2;
        if(n[mid]>n[mid+1]){
            return helper(n, s, mid);
        }else{
            return helper(n, mid+1, e);
        }
    }
    public int findPeakElement(int[] nums) {
        // https://leetcode.com/discuss/17793/find-the-maximum-by-binary-search-recursion-and-iteration
        // 要求O(lgn) complexity?
        // 用一樣的邏輯用二分法去找, 畫圖就可以知道如何逼近
        
        return helper(nums, 0, nums.length-1);
        
        // 很漂亮的O(n)
        /*
        for(int i = 1; i < nums.length; i ++)
        {
            if(nums[i] < nums[i-1])   //找到一個往下的轉折點
            {
                return i-1;
            }
        }
        return nums.length-1;
        */
        
        /*
        // O(n)硬幹法
        // 1 ms
        // edge case
        if(nums==null || nums.length==0 || nums.length==1) return 0;
        
        // check head and tail
        if(nums[0] > nums[1]) return 0;
        if(nums[nums.length-1] > nums[nums.length-2]) return nums.length-1;
        
        for(int i=1;i<nums.length-1;i++){
            if( (nums[i]>nums[i-1]) && (nums[i]>nums[i+1]) )    return i;
        }
        
        return -1;  // impossible case
        */
    }
}