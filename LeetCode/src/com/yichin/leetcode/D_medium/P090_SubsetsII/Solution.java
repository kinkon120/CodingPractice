package com.yichin.leetcode.D_medium.P090_SubsetsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // http://www.jiuzhang.com/solutions/subsets-ii/
        // 如何check duplicate...
        // [1,1,2]應該有
        // [], [1], [1,1]
        // [1,2], [2] -> 不檢查dup的話會有兩個[1,2]
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        if(nums==null || nums.length==0)    return result;
        helper(nums, list, 0, result);
        return result;
    }
    
    void helper(int [] nums, List<Integer> list, int pos, List<List<Integer>> result){
        result.add(new ArrayList<Integer>(list));
        for(int i=pos; i<nums.length;i++){
            // 最重要的精神在此->skip duplicate
            // 當我們已經有[], [1]時, 往下call一層pos=1, nums[1]=1會被加進去, 因為i=1=pos, 不需要檢查重複
            // 但我們已經有[], [1], [1,1],[1,1,2], [1,2]之後在返回時, 想把num[1]=1把擺到第一個去, 此時會duplicate
            if ( i != pos && nums[i] == nums[i - 1]) { // i必須要不等於pos, 因為他always要被選進去才行
                continue;
            }
            list.add(nums[i]);
            // recursive
            helper(nums, list, i+1, result);

            list.remove(list.size()-1); // remove the last one
        }
    }
}
