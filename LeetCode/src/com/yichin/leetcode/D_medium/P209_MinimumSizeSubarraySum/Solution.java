package com.yichin.leetcode.D_medium.P209_MinimumSizeSubarraySum;
/*
Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.
*/
public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        // https://discuss.leetcode.com/topic/26814/o-n-o-nlogn-solutions-both-o-1-space
        // O(N) - keep a moving window expand until sum>=s, then shrink util sum<s. 
        // Each time after shrinking, update length. (similar to other solutions, just removed unnecessary min value assignment)
        
        int min = Integer.MAX_VALUE;
        int s=0;
        int e=0;
        int sum=0;
        while(e<nums.length){
            while(sum < target && e < nums.length)  sum += nums[e++];   // try to add more
            // 不能做e--
            // 離開while loop時, 其實e會多往後一位
            
            // 要比target大才做...不然沒意思
            if( sum >= target ){
                while(sum >= target && s<e) sum -= nums[s++];
                // 不能s--
                // 離開while loop時, 其實s會多往後一位
                min = Math.min(min, e-s+1);   //實際上是(e-1)-(s-1)+1  最後的+1是包含頭尾
            }
        }
        
        return min==Integer.MAX_VALUE ? 0 : min;
    }
}