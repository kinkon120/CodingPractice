package com.yichin.leetcode.array.P053_MaximumSubarray;
/*
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.
*/

public class Solution {
    public int maxSubArray(int[] nums) {

        if(nums==null || nums.length==0)    return 0;

        // https://leetcode.com/discuss/19614/dp-solution-%26-some-thoughts        
        // 3ms, time O(n)
        int [] dp = new int [nums.length];    //dp[i] means the maximum subarray ending with nums[i]; 第i個必選
        dp[0]=nums[0];
        int max = dp[0];
        
        // DP
        // maxSubArray(A, i) = maxSubArray(A, i - 1) > 0 ? maxSubArray(A, i - 1) : 0 + A[i]; 
        
        for(int i=1;i<nums.length;i++){
            if(dp[i-1] > 0){
                dp[i] = dp[i-1]+nums[i];
            }
            else{
                dp[i] = nums[i];
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}