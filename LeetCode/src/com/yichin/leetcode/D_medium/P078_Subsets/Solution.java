package com.yichin.leetcode.D_medium.P078_Subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
Given a set of distinct integers, nums, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // https://leetcode.com/discuss/9213/my-solution-using-bit-manipulation
        // bit trick版本
    	// 3ms
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int max= 1<<nums.length; 
        for(int i=0; i<max; i++){
            int k = i; // 直接對i操作會導致i值大混亂...
            List<Integer> list = new ArrayList<Integer>();
            int digit=0;
            while(k!=0){
                if(k%2==1)  list.add(nums[digit]);
                k/=2;
                digit++;    // 不能把這行省略並到上面去  會出問題的...
            }
            lists.add(list);
        }
        return lists;
        
        // https://leetcode.com/discuss/25696/simple-java-solution-with-for-each-loops
        // for loop版本
        // 一樣3ms
        /*
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        List<Integer> initial = new ArrayList<Integer>();
        lists.add(initial);
        Arrays.sort(nums);
        for(int n : nums){
            List<List<Integer>> tmp = new ArrayList<List<Integer>>();
            for(List<Integer> list : lists){
                List<Integer> copy = new ArrayList<Integer>(list);
                copy.add(n);
                tmp.add(copy);
            }
            lists.addAll(tmp);
        }
        return lists;
        */
        
        // 3 ms, 自己想的, 但似乎不用用到recursive...
        /*
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        lists.add(list);
        
        Arrays.sort(nums);
        helper(nums, lists, 0);
        return lists;
        */
    }
    
    /*
    void helper(int[] nums, List<List<Integer>> lists, int index){
        // reach end
        if(nums==null || nums.length==index)   return;
        
        // add nums[index] into current subset
        List<List<Integer>> tmp = new ArrayList<List<Integer>>();
        for(List<Integer> list : lists){
            List<Integer> copy = new ArrayList<Integer>(list);
            copy.add(nums[index]);
            
            tmp.add(copy);
        }
        lists.addAll(tmp);
        
        helper(nums, lists, index+1);
    }
    */
}