package com.yichin.leetcode.twopointer.H287_FindTheDuplicateNumber.copy;
/*
Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), 
prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

Note:
You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n^2).
There is only one duplicate number in the array, but it could be repeated more than once.
*/

public class Solution {
    public int findDuplicate(int[] nums) {
        
        // https://discuss.leetcode.com/topic/25685/java-o-n-time-and-o-1-space-solution-similar-to-find-loop-in-linkedlist
        // 這個圖解很棒, 但減1不會有助於理解問題...
        // 當有兩個node 指向同一個node, 代表有重複!!
        // https://discuss.leetcode.com/topic/25913/my-easy-understood-solution-with-o-n-time-and-o-1-space-without-modifying-the-array-with-clear-explanation
        // code 參考上面
        
    	if (nums.length > 1)
    	{
    		int slow = nums[0];
    		int fast = nums[nums[0]];
    		while (slow != fast)
    		{
    			slow = nums[slow];
    			fast = nums[nums[fast]]; // 這樣等於是跳兩次
    		}
    		// 此時找到第一個重複點, 但未必是cycle head
    
    		fast = 0;
    		while (fast != slow)
    		{
    			fast = nums[fast];
    			slow = nums[slow];
    		}
    		return slow;
    	}
    	return -1;
        
    }
}