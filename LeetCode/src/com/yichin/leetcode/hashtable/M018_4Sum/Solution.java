package com.yichin.leetcode.hashtable.M018_4Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.
    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)

*/
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // https://leetcode.com/discuss/32594/clean-accepted-java-o-n-3-solution-based-on-3sum
        // 這個解法比較清晰
    	// 跟3-sum一樣的邏輯
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums==null || nums.length<4) return result;
        
        Arrays.sort(nums);
        for(int i=0; i<nums.length-3;i++){
            if(i>0 && nums[i]==nums[i-1]) continue; // each one must be unique. 前面加上i>0是代表第一個
            for(int j=i+1; j<nums.length-2;j++){
                if(j>i+1 && nums[j]==nums[j-1]) continue;
                
                // 簡單優化: 若nums[i]+nums[j]>0, 就不用繼續了
                
                int low=j+1; 
                int high=nums.length-1;
                int rest = target - nums[i] - nums[j];
                while(low < high){
                    if(rest == nums[low]+nums[high]){
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[low]);
                        list.add(nums[high]);
                        result.add(list);
                        
                        // skip dup
                        while(low<high&&nums[low]==nums[low+1])low++;
                        while(low<high&&nums[high]==nums[high-1])high--;
                        low++;
                        high--;
                    }else if(rest > nums[low]+nums[high]){
                        low++;
                    }else{
                        high--;
                    }
                }
            }
        }
        return result;
    }
}