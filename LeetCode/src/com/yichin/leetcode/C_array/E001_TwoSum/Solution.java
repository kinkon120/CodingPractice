package com.yichin.leetcode.C_array.E001_TwoSum;

import java.util.HashMap;
import java.util.Map;

/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
UPDATE (2016/2/13):
The return format had been changed to zero-based indices. Please read the above updated description carefully.
*/
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        // O(n) time, O(n) space
        // 6 ms
    	// 這個方法可以處理2+2 =4的case  (input [1,2,2,9], target 4)    	
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>(); // value 為index
        
        for(int i=0; i<nums.length; i++){
            if(hm.containsKey(target-nums[i])){
                return new int [] {hm.get(target-nums[i]),i};
            }else{
                hm.put(nums[i], i);
            }
        }
        return new int [2];
        
        // O(n^2) time, O(1) space
        // 44 ms
        /*
        for(int i=0; i<nums.length-1; i++){
            for(int j=i+1; j<nums.length;j++){
                if(nums[i]+nums[j] == target){
                    return new int [] {i,j};
                }
            }
        }
        return new int [2];
        */
    }
}