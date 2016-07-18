package com.yichin.leetcode.C_hashtable.E219_ContainsDuplicateII;

import java.util.HashSet;
import java.util.Set;

/*
Given an array of integers and an integer k, 
find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] 
and the difference between i and j is at most k.
*/
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // https://leetcode.com/discuss/38445/simple-java-solution
        // 直接用set做
        // 可以直接把nums size為1的狀況排除
        Set <Integer> set = new HashSet<Integer>();
        for(int i=0; i< nums.length;i++){
            if(i>k) set.remove(nums[i-k-1]);    // 踢除隔太遠的
            if(!set.add(nums[i]))   return true;
        }
        return false;
    }
}