package com.yichin.leetcode.D_medium.P015_3Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
*/
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // https://leetcode.com/discuss/23638/concise-o-n-2-java-solution
        // O(n^2)
        Arrays.sort(nums);	// O(nlgn)
        int len = nums.length;
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        for(int i=0;i<len-2;i++){
            
        	// little optimization, 如果第一個數已經大於0，後面根本不用繼續做了...
            if(nums[i] > 0) break;
            
            // avoid duplicate
            if(i>0 && nums[i]==nums[i-1])    continue;
            
            int lo = i+1;
            int hi = len-1;
            // 針對剩下的部分  找到和為 -nums[i]的所有組合
            while(lo<hi){
                int sum = nums[lo] + nums[hi] + nums[i];
                if( sum ==0 ){
                    // add to results
                    // 7ms 快一點點  且寫法好看!
                    results.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    
                    // 8ms
                    /*
                    List<Integer> result = new ArrayList<Integer>();
                    result.add(nums[i]);
                    result.add(nums[lo]);
                    result.add(nums[hi]);
                    results.add(result);
                    */
                    
                    
                    // avoid duplicate
                    while( lo < hi && nums[lo] == nums[lo+1])   lo++;
                    while( lo < hi && nums[hi] == nums[hi-1])   hi--; 
                    lo++;
                    hi--;
                }else if(sum < 0) {
                    // add more
                    lo++;
                }else{
                    // add less
                    hi--;
                }
            }
        }
        return results;
        
        
        // brute force O(n^3)
        // 會超時!
        /*
        Arrays.sort(nums);
        int len = nums.length;
        Set<List<Integer>> sets = new HashSet<List<Integer>>();
        for(int i=0;i<len-2;i++){
            if(nums[i] > 0) break;
            for(int j=i+1;j<len-1;j++){
                if(nums[i]+nums[j] > 0) break;
                for(int k=j+1;k<len;k++){
                    List<Integer> result = new ArrayList<Integer>();
                    result.add(nums[i]);
                    result.add(nums[j]);
                    result.add(nums[k]);
                    sets.add(result);
                }
            }
        }
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        results.addAll(sets);
        
        return results;
        */
    }
}