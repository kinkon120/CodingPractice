package com.yichin.leetcode.D_easy.P198_HouseRobber;
/*
You are a professional robber planning to rob houses along a street. 
Each house has a certain amount of money stashed, 
the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, 
determine the maximum amount of money you can rob tonight without alerting the police.
*/

public class Solution {
    public int rob(int[] nums) {
        // 根據下面的解法，再精進成Space O(1)的方法
        // https://leetcode.com/discuss/30020/java-o-n-solution-space-o-1
        // 0 ms
        /*
        if(nums==null || nums.length==0)    return 0;
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0], nums[1]);
        int robCur = nums[1];
        int notRobCur = nums[0];
        
        for(int i=2;i<nums.length;i++){
            int tmp = notRobCur;
            notRobCur = Math.max(notRobCur, robCur);    // 利用前一次的state
            robCur = tmp + nums[i];
            
        }
        return Math.max(robCur, notRobCur);
        */
        
        
        // 2 ms. Space O(n)
        // 自己想的 
        if(nums==null || nums.length==0)    return 0;
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0], nums[1]);
        
        // DP problem
        int [] max = new int [nums.length];
        max[0] = nums[0];   // 必搶第一間
        max[1] = nums[1];   // 必搶第二間
        
        int result= Math.max(nums[0], nums[1]);
        for(int i=2;i<nums.length;i++){
            int curMax = 0;
            for(int j=0;j<i-1;j++){
                curMax = Math.max(curMax,max[j]);
            }
            max[i] = curMax+nums[i];
            if(max[i] > result) result = max[i];
        }
        
        return result;
    }
}