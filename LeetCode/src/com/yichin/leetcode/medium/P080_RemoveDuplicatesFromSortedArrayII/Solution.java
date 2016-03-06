package com.yichin.leetcode.medium.P080_RemoveDuplicatesFromSortedArrayII;
/*
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. 
It doesn't matter what you leave beyond the new length.
*/
public class Solution {
    public int removeDuplicates(int[] nums) {
        //https://leetcode.com/discuss/42348/3-6-easy-lines-c-java-python-ruby
        // 超屌 ~_~
        int i = 0;
        for (int n : nums){
            if (i < 2 || n > nums[i-2]){
                nums[i++] = n;
            }
        }
        return i;    
    }
}