package com.yichin.leetcode.C_array.M039_CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
Given a set of candidate numbers (C) and a target number (T), 
find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≦ a2 ≦ … ≦ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 
*/

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // https://leetcode.com/discuss/22651/java-solution-using-recursive
        
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        helper(candidates, 0, target, new ArrayList<Integer>(), results);
        return results;
        
    }
    
    void helper(int [] nums, int start, int target, List<Integer> curList, List<List<Integer>> results){
        if(target == 0){
            // 確定找到一組解
            results.add(new ArrayList<Integer>(curList));
        }
        if(target > 0){
            for(int i=start; i<nums.length && target>=nums[i]; i++){
            	//  一直往後面找就是了
                curList.add(nums[i]);
                helper(nums, i, target-nums[i], curList, results);
                curList.remove(curList.size()-1);   // 重要!!要把之前的加入的移除掉
            }
        }
    }
}