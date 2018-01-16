package com.yichin.leetcode.C_array.E561_ArrayPartitionI;

import java.util.Arrays;

class Solution {
    public int arrayPairSum(int[] nums) {
        /*
        Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn)  
        which makes sum of min(ai, bi) for all i from 1 to n as large as possible.

        Example 1:
        Input: [1,4,3,2]

        Output: 4
        Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
        Note:
        n is a positive integer, which is in the range of [1, 10000].
        All the integers in the array will be in the range of [-10000, 10000].

        */
        
        // 基本上...sort之後，把奇數個的數加起來就好
        // a[n]為sorted array
        // a[n-2]跟a[n-1]配一起，選a[n-2]出來相加
                
        Arrays.sort(nums);
        int sum = 0;
        // 太久沒寫code...終止條件不可以設為 i<nums.length-2
        for(int i=0; i<nums.length; i+=2){
            sum += nums[i];
        }
        return sum;
    }
}