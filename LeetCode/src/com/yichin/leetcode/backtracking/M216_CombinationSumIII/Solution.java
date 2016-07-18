package com.yichin.leetcode.backtracking.M216_CombinationSumIII;

import java.util.ArrayList;
import java.util.List;

/*
Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.


Example 1:

Input: k = 3, n = 7

Output:

[[1,2,4]]

Example 2:

Input: k = 3, n = 9

Output:

[[1,2,6], [1,3,5], [2,3,4]]

*/
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        // https://discuss.leetcode.com/topic/26351/simple-and-clean-java-code-backtracking
        // recursive call
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> comb = new ArrayList<Integer>();
        helper(result, comb, k, 1, n);
        return result;
        
    }
    
    void helper(List<List<Integer>> ans, List<Integer> comb, int k, int start, int n){
        if(n==0 && comb.size()==k){
            ans.add(new ArrayList<Integer>(comb));
            return;
        }
        
        // recursive
        for(int i=start;i<=9;i++){
            comb.add(i);
            helper(ans, comb, k, i+1, n-i);
            comb.remove(comb.size()-1);
        }
    }
}