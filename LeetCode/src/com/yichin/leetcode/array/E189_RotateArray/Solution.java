package com.yichin.leetcode.array.E189_RotateArray;
/*
Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
*/

public class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        
        // edge case
        if(len==1) return;
        k %= len;   // prevent super big k
        
        // https://leetcode.com/discuss/30527/three-way-solve-this-problem-the-first-way-interesting-java

        // method 1: brute force, space O(k)
        // 1 ms
        // 可以讓space只有 k%len的複雜度, 
        /*
        int [] n = new int [k]; // O(k%len) space
        
        for(int i=len-k;i<len;i++){
            n[i-len+k] = nums[i];
            // back up 567
        }
        for(int i=len-1;i>=k;i--){   //一定要從後面開始填
            nums[i]=nums[i-k];
            // move 1234
        }
        for(int i=0;i<k;i++){
            nums[i]=n[i];
        }
        */
        
        // method 2: reverse three times
        reverse(nums,0,len-1);
        reverse(nums,0,k-1);
        reverse(nums,k,len-1);
        
        
    }
    
    void reverse(int [] n, int s, int e){
        while(s < e){
            // XOR swap
            n[s] ^= n[e];
            n[e] ^= n[s];
            n[s] ^= n[e];
            s++;
            e--;
        }
    }
}