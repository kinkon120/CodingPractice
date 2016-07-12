package com.yichin.leetcode.array.M016_3SumClosest;

import java.util.Arrays;

/*
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // https://discuss.leetcode.com/topic/5192/java-solution-with-o-n2-for-reference
        // O(n^2)
        // 先sort, 再前後移動
        
        // sort O(nlgn)
        Arrays.sort(nums);
        
        // O(n^2)
        int result = nums[0]+nums[1]+nums[2];
        for(int i=0; i<nums.length-2; i++){ // check the last condition
            int s=i+1; //代表第i個必選
            int e=nums.length-1;
            while(s<e){
                int sum = nums[i] + nums[s] + nums[e];
                int diff = Math.abs(result-target);
                int diff2 = Math.abs(sum-target);
                if(diff > diff2){
                    result = sum;
                }
                
                if(sum > target)    e--;
                else s++;
            }
        }
        return result;
    }
}