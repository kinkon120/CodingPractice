package com.yichin.leetcode.medium.P034_SearchForARange;
/*
Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
*/
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        // https://leetcode.com/discuss/18242/clean-iterative-solution-binary-searches-with-explanation
        // https://leetcode.com/discuss/19368/very-simple-java-solution-with-only-binary-search-algorithm
        
        // тオ娩т娩
        // 璶安砞edge case
        // 1. 程计target
        // 2. 程计target
        // 3. target瞶絛瞅ずтぃ
        int s = 0;
        int e = nums.length-1;
        
        int [] result = new int [] {-1,-1};
        if(nums[0]>target || nums[e]<target) return result;
        
        // find left
        while(s<e){
            int mid = (s+e)/2;
            if(nums[mid] < target)  s=mid+1;
            else e=mid;
        }
        // 1,1,2,2,2,2,2,2,3,3
        // 0 1 2 3 4 5 6 7 8 9
        // s       m         e
        // s   m   e
        // s m e
        // s and e meet in index 2
        
        // nums[s]琌材ぃtarget计
        // ぃmatchtarget常тぃ
        if(nums[s]!= target) return result;
        
        result[0]=s;
        
        // find right
        e = nums.length; // ぃノnums.length-1, Τ程计琌target
        while(s<e){
            int mid = (s+e)/2;
            if(nums[mid] < target+1)  s=mid+1;
            else e=mid;
        }
        // 1,1,2,2,2,2,2,2,3,3
        // 0 1 2 3 4 5 6 7 8 9
        //     s     m       e
        //             s m   e
        //                 s e (m is at index 8)
        //                 s/e meets at index 8
        
        result[1]=s-1;
        return result;
    }
}