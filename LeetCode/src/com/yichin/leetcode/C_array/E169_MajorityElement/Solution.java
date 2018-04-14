package com.yichin.leetcode.C_array.E169_MajorityElement;

import java.util.Arrays;

/*
Given an array of size n, find the majority element. The majority element is the element that appears more than ceilng of (n/2) times.

You may assume that the array is non-empty and the majority element always exist in the array.
*/
public class Solution {
    public int majorityElement(int[] nums) {
        // Sort and then get the middle num
    	// O(n lg n) 3ms
    	// 簡單  但是還不是最佳解
    	// 面試只要會這個版本就好  simple is enough
        Arrays.sort(nums);
        return nums[nums.length/2];
        
        /* counting algorithm. O(n) 3ms，但是我不會解釋他的原理
        // 1231417191
        int n = nums[0];
        int cnt = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==n){
                cnt++;
            }else{
                // 用121的例子想一想
                cnt--;
                if(cnt==0){	// 代表這個佔多數的數字出現的次數已經被其他數字打平了!
                    cnt=1;
                    n=nums[i];
                }
            }
        }
        return n;
        */

    }
}