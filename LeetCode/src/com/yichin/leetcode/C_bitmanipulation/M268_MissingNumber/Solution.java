package com.yichin.leetcode.C_bitmanipulation.M268_MissingNumber;

import java.util.Arrays;

/*
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.

Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
*/
public class Solution {
    public int missingNumber(int[] nums) {
        // https://leetcode.com/discuss/71091/share-four-different-solutions
        // sort
        // Time: O(nlgn), Space: O(1)
        // 14ms
        Arrays.sort(nums);
        int m=0;
        int l=0;
        int h=nums.length-1;
        while(l<h){
            m=(l+h)/2;
            if(nums[m]==m){
                l=m+1;
            }else{
                h=m-1;
            }
        }
        
        if(nums[l]!=l){
            return l;
        }
        else{
            return l+1;
        }
        
        // https://leetcode.com/discuss/54694/java-bit-manipulation-solution-o-n-time-o-1-space
        // https://leetcode.com/discuss/58647/line-simple-java-bit-manipulate-solution-with-explaination
        // XOR: xor all number (假設有index是0~n, 少掉的number是n-k)
        // XOR 全部數字之後，只有n-k會被XOR一次， 其他數字都會因為a^a=0被抵銷掉
        // 1 ms
        // O(n) time, O(1) space
        /*
        int x=0;
        for(int i=0;i<nums.length;i++){
            x = x^i^nums[i];
        }
        x^=nums.length; // 最後一個數字
        return x;
        */
        
        // https://leetcode.com/discuss/76749/java-o-n-o-1-solution-using-math-knowledge
        // Math Knowledge
        // 1ms
        // O(n) time, O(1) space
        /*
        int size = nums.length;
        int total = size*(size+1)/2;
        for(int num : nums){
            total -= num;
        }
        return total;
        */
    }
}