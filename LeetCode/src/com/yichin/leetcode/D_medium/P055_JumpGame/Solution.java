package com.yichin.leetcode.D_medium.P055_JumpGame;

/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
*/
public class Solution {
    public boolean canJump(int[] nums) {
        // https://leetcode.com/discuss/22560/java-solution-easy-to-understand
        // 用max紀錄目前可以到的最遠點
        int max = 0;
        for(int i=0; i<nums.length; i++){
            if(i>max)   return false;	// 目前的i無法reach
            if(max>nums.length-1)   return true;	// 已經確定可以到最後一點
            
            max = max > i+nums[i] ? max : i+nums[i];
        }
        return true;
        
        // brute force
        /*
        if(nums==null || nums.length<2)    return true;
        
        int len = nums.length;
        // now we have at least 2 node
        boolean [] reach = new boolean [len];
        reach[0] = true;
        
        for(int i=0 ; i< len; i++){
            if(reach[i]==false) return false; 
            
            if(i+nums[i] >= len-1)    return true; // find a way already
            
            // chech how many index we can reach now
            for(int j=1; j<=nums[i] && i+j<len;j++){ // use && for termination, not a simple comma
                reach[i+j] = true;
            }
        }
        
        return reach[len-1];
        */
    }
}