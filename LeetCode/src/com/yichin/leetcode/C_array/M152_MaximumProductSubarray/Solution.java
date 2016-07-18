package com.yichin.leetcode.C_array.M152_MaximumProductSubarray;
/*
Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
*/

public class Solution {
    public int maxProduct(int[] n) {
        // https://discuss.leetcode.com/topic/3607/sharing-my-solution-o-1-space-o-n-running-time
        // 得記錄當前最大跟最小的狀況
        
        int maxPrev = n[0];
        int minPrev = n[0];
        int maxSofar = n[0];
        
        int maxHere, minHere;
        
        for(int i=1;i<n.length;i++){
            int k = n[i];
            maxHere = Math.max( Math.max(maxPrev*k, minPrev*k), k); //留著最後一個k是因為如果前一個是0的話 maxPre跟minPre都會是0...
            minHere = Math.min( Math.min(minPrev*k, maxPrev*k), k);
            if(maxHere > maxSofar)  maxSofar=maxHere;
            
            maxPrev = maxHere;
            minPrev = minHere;
        }
        
        return maxSofar;
    }
}