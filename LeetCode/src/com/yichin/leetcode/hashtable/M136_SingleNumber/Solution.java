package com.yichin.leetcode.hashtable.M136_SingleNumber;

/*
	Given an array of integers, every element appears twice except for one. Find that single one.
	Note:
	Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/

public class Solution {
	// XOR trick
    public int singleNumber(int[] nums) {
    	int x = 0;
        for(int num : nums){
        	x^=num;
        }
        return x;
    }
}