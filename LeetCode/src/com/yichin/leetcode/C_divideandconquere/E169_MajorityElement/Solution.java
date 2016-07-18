package com.yichin.leetcode.C_divideandconquere.E169_MajorityElement;

import java.util.Arrays;

/*
Given an array of size n, find the majority element. The majority element is the element that appears more than ? n/2 ? times.

You may assume that the array is non-empty and the majority element always exist in the array.
*/
public class Solution {
    public int majorityElement(int[] nums) {
        // Sort and then get the middle num
    	// O(n lg n) 3ms
    	// 簡單  但是不夠屌
        Arrays.sort(nums);
        return nums[nums.length/2];
        
        /* counting algorithm. O(n) 3ms
        // 1231417191
        int n = nums[0];
        int cnt = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==n){
                cnt++;
            }else{
                // 用121的例子想一想
                cnt--;
                if(cnt==0){
                    cnt=1;
                    n=nums[i];
                }
            }
        }
        return n;
        */

    }
}