package com.yichin.leetcode.C_divideandconquere.M215_KthLargestElementInAnArray;

import java.util.Arrays;
/*
Find the kth largest element in an unsorted array. 
Note that it is the kth largest element in the sorted order, not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note: 
You may assume k is always valid, 1 ≦ k ≦ array's length.
*/

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        // sort first: time O(nlgn); space O(1)
        // 4ms
        Arrays.sort(nums);
        return nums[nums.length - k];
        
        
        // 15ms
        // heap (priority queue): keep k elements in heap. time O(nlgk) + space O(k)
        /*
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int n : nums){
            pq.add(n);  // or pq.offer(n);
            if(pq.size()>k){
                pq.poll();  // 不是pq.pop()
            }
        }
        return pq.peek();
        */
    }
}