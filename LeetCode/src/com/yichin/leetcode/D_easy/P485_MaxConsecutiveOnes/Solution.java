package com.yichin.leetcode.D_easy.P485_MaxConsecutiveOnes;
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        /*
        Given a binary array, find the maximum number of consecutive 1s in this array.

        Example 1:
        Input: [1,1,0,1,1,1]
        Output: 3
        Explanation: The first two digits or the last three digits are consecutive 1s.
            The maximum number of consecutive 1s is 3.
        Note:

        The input array will only contain 0 and 1.
        The length of input array is a positive integer and will not exceed 10,000
        */
        
        // 直覺解...
        
        // edge case
        if (nums==null || nums.length==0)   return 0;
        
        int max = 0;
        int cur = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i]==1) {
                cur++;
            } else {
                if (cur > max)  max = cur;
                cur = 0;
            }
        }
        
        if (cur > max) {
            max = cur;   
        }
        
        return max;
    }
}