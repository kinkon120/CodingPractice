package com.yichin.leetcode.C_array.M228_SummaryRanges;

import java.util.ArrayList;
import java.util.List;

/*
Given a sorted integer array without duplicates, return the summary of its ranges.

For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
*/
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();
        // edge case
        if(nums==null || nums.length==0)  return result;
        
        int s = nums[0];
        for(int i=1; i< nums.length; i++){
            if(nums[i]==nums[i-1]+1){
                continue;
            }else{
                // find a range
                result.add(getStr(s, nums[i-1]));
                s=nums[i];
            }
        }
        result.add(getStr(s, nums[nums.length-1]));
        return result;
    }
    
    String getStr(int i, int j){
        if(i==j)    return ""+i;
        return i+"->"+j;
    }
}