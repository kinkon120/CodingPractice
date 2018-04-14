package com.yichin.leetcode.C_array.E217_ContainsDuplicate;

import java.util.HashSet;
import java.util.Set;

/*
Given an array of integers, find if the array contains any duplicates. 
Your function should return true if any value appears at least twice in the array, 
and it should return false if every element is distinct.
*/

// https://leetcode.com/discuss/37219/possible-solutions

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        /*
        // 暴力法硬幹 time (O^2), space O(1)
        // Time Limit Exceeded...
        for(int i=0; i<nums.length-1;i++){
            for(int j=i+1; j<nums.length;j++){
                if(nums[i]==nums[j])  return true;
            }
        }
        return false;
        */
        
        /*
        // Sort and then compare. Time O(n log n), Space O(1)
        // 6ms
        Arrays.sort(nums);
        for(int i=0; i<nums.length-1;i++){
            if(nums[i]==nums[i+1])    return true;
        }
        return false;
        */
        
        // HashSet. Time O(n), Space O(n)
        // 10ms
        Set<Integer> set = new HashSet<Integer>();
        for(int num : nums){
            if(!set.add(num)){
                return true;
            }
        }
        return false;
    }
}