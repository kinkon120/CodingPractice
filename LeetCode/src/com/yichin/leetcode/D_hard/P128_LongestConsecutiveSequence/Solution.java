package com.yichin.leetcode.D_hard.P128_LongestConsecutiveSequence;

import java.util.HashSet;
import java.util.Set;

/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
*/
public class Solution {
    public int longestConsecutive(int[] nums) {
        // https://leetcode.com/discuss/38619/simple-o-n-with-explanation-just-walk-each-streak
        // --> 這個版本worst case會是O(n^2)
        
        // https://leetcode.com/discuss/60632/simple-fast-java-solution-using-set
        // 這個才是O(n), visited一個element之後, 就要移除之
        
        Set <Integer> set = new HashSet<Integer>();
        for(int n : nums){
            set.add(n);
        }
        
        int result = 1;
        for(int n : nums){
            int max = 1;
            set.remove(n);
            
            int right=1;
            while(set.remove(n+right))  right++;
            max += (right-1);   //最後一個right其實不存在
            
            int left=1;
            while(set.remove(n-left))  left++;
            max += (left-1);    //最後一個left其實不存在
            
            
            // 已經remove成功的代表已經visit過了
            result = Math.max(max,result);
        }
        return result;
    }
}