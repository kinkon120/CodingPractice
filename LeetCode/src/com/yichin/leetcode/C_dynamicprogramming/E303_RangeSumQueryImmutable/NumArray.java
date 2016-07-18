package com.yichin.leetcode.C_dynamicprogramming.E303_RangeSumQueryImmutable;

/*
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
Note:
You may assume that the array does not change.
There are many calls to sumRange function.
*/

public class NumArray {
    // https://leetcode.com/discuss/68696/java-simple-o-n-init-and-o-1-query-solution
    int [] sum;
    public NumArray(int[] nums) {
        // edge case
        if(nums==null || nums.length==0) return;	// 要考慮!!
        
        sum = new int [nums.length];
        sum[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            sum[i] = sum[i-1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if(i==0)    return sum[j];	//多舉例以免漏掉這種基本錯誤...
        return sum[j]-sum[i-1];
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);