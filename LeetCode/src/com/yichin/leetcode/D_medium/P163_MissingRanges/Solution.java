package com.yichin.leetcode.D_medium.P163_MissingRanges;

import java.util.ArrayList;
import java.util.List;

/*
Given a sorted integer array where the range of elements are [lower, upper] inclusive, return its missing ranges.

For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].

Subscribe to see which companies asked this question
*/
public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        // 就用上面的例子走一遍
        // 頭尾的case怎麼處理
        // https://leetcode.com/discuss/45508/accepted-java-solution-with-explanation
        // 當走到不連續的數字時, nums[i]-1就是end
        List<String> result = new ArrayList<>();
        
        int next = lower;
        for(int i=0; i<nums.length;i++){
            if(next == nums[i]){
                next++;
                // next代表下一個潛在missing number
                continue;
            }
            
            // find a range here...
            // 確認可以應付nums[0]即大於lower的狀況!
            result.add(getRange(next, nums[i]-1));
            next=nums[i]+1;
        }
        
        // check final range, 若next > upper, 代表nums[nums.length-1]已涵蓋upper
        // 不可以只是next != upper
        if(next <= upper)   result.add(getRange(next, upper));
        
        return result;
    }
    
    String getRange(int n1, int n2){
        return n1==n2 ? n1+"" : n1+"->"+n2;
    }
}
