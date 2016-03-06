package com.yichin.leetcode.medium.P300_LongestIncreasingSubsequence;

/*
Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. 
Note that there may be more than one LIS combination, it is only necessary for you to return the length.

Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity?
*/

public class Solution {
    int checkIndex(int [] list, int e, int k){
    	if(k<=list[0])	return 0;
    	if(e>0 && list[e-1] <k)	return e;
    	
        int s = 0;
        // binary search
        while(s<=e){
            int m = (s+e)/2;
            if(list[m]==k)  return m;
            if(list[m]>k){
                e=m-1;
            }else{
                s=m+1;
            }
        }
        return s;
    }
    public int lengthOfLIS(int[] nums) {
        // 有一種binary search的方法可以達到O(n lg n), 但是看不懂...
        // http://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
        // 上面這個有範例...
        // 基本上要維持list of LIS, 然後每遇到一個新的element的時候, 要做判斷
        // Our strategy determined by the following conditions,
        /*
        1. If A[i] is smallest among all end candidates of active lists, we will start new active list of length 1.
        2. If A[i] is largest among all end candidates of active lists, we will clone the largest active list, and extend it by A[i].
        3. If A[i] is in between, we will find a list with largest end element that is smaller than A[i]. Clone and extend this list by A[i]. We will discard all other lists of same length as that of this modified list.
        上面這個方法要keep住數個list, 但優化之後可以只keep一個就好
        */
        // 1ms...爆快
        // 如果用Arrays.binarysearch會需要4 ms...
    	// 但是code太醜了...只要會n^2的方法就好了
        
        if(nums==null || nums.length==0)    return 0;
        
        int [] list = new int [nums.length];
        list[0]=nums[0];
        int len=1;
        for(int x : nums){
            int i = checkIndex(list, len, x);
            list[i] = x;
            if(i==len)  len++;
        }
        
        return len;
        
        
        /*
        // http://www.jiuzhang.com/solutions/longest-increasing-subsequence/
        // 跟這解法也相似: https://leetcode.com/discuss/69893/java-solution-dp-simple
        // DP, use a array to store current solution
        // 自己寫出來的  爽~~
        // 23ms. Time: O(n^2)
        
        if(nums==null || nums.length==0)    return 0;
        
        int max = 1;    // 再不濟也可以選一個...
        // a[i] store the longest value where we "must" select i-th element
        int [] a = new int [nums.length];
        a[0]=1;
        for(int i=1;i<nums.length;i++){
            int curMax=1;   // at least select itself...
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    curMax = Math.max(curMax, a[j]+1);
                }
            }
            a[i]=curMax;
            if(curMax > max) max =curMax;
        }
        return max;
        */
    }
    
}