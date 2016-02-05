package com.yichin.leetcode.easy.P169_MajorityElement;

import java.util.Arrays;

/*
Given an array of size n, find the majority element. The majority element is the element that appears more than ? n/2 ? times.

You may assume that the array is non-empty and the majority element always exist in the array.
*/
public class Solution {
    public int majorityElement(int[] nums) {
        // Sort and then get the middle num
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}