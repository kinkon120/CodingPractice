package com.yichin.leetcode.D_easy.P228_SummaryRanges;

import java.util.ArrayList;
import java.util.List;

/*
Given a sorted integer array without duplicates, return the summary of its ranges.

For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
*/
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();
        if(nums==null || nums.length==0)    return result;
        if(nums.length==1){
            String s = nums[0]+"";
            result.add(s);
            return result;
        }
        
        int start = nums[0];
        int last = nums[0];
        String s;
        for(int i=1; i<nums.length; i++){
            if(nums[i]-1 == last){  // continue current duration
                last++;
            }else{
                // store a new duration
                s=getString(start, last);
                result.add(s);
                
                start = nums[i];
                last = nums[i];
            }
        }
        // check the last duration
        s=getString(start, last);
        result.add(s);        
        
        return result;
    }
    
    String getString(int start, int last){
        if(start==last) return start+"";
        return start+"->"+last;
    }
}