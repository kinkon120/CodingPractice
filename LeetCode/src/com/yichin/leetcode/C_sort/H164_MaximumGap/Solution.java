package com.yichin.leetcode.C_sort.H164_MaximumGap;
/*
Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Try to solve it in linear time/space.

Return 0 if the array contains less than 2 elements.

You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
*/

public class Solution {
    public int maximumGap(int[] nums) {
        // http://www.cnblogs.com/higerzhang/p/4176108.html
        // http://findingsea.github.io/blog/2015/05/06/maximum-gap-at-leetcode/
        // use bucket sore concept
        /*
        Suppose there are N elements and they range from A to B.
        Then the maximum gap will be no smaller than ceiling[(B - A) / (N - 1)]
        Let the length of a bucket to be len = ceiling[(B - A) / (N - 1)], then we will have at most num = (B - A) / len + 1 of bucket
        for any number K in the array, we can easily find out which bucket it belongs by calculating loc = (K - A) / len and therefore
        maintain the maximum and minimum elements in each bucket.
        Since the maximum difference between elements in the same buckets will be at most len - 1, so the final answer will not be taken 
        from two elements in the same buckets.
        For each non-empty buckets p, find the next non-empty buckets q, then q.min - p.max could be the potential answer to the question. 
        Return the maximum of all those values.
        */
        
        /*  step1: 先掃一便決定max/min
            step2: 決定有幾個bucket. 最小的gap剛好是(max-min)/(array size-1) -> 剛好平均分配. Ex: 1 3 5 7 9 -> (9-1)/4=2
                   另一個case是max-min=100, size=7,  100/6=16.6 (minGap), 則我們需要 ceil(100/16.6)+1存所有的數字
                   由於minGap是16.6, 我們取16的話, 去切100只用6個bucket會不夠
                   所以要在多用一個bucket去切材保證數量夠用
            step3: 承上例bucket數量 100/16.6+1=7
        */
        
        // sorted: 1,7,9,108,876 -> N = 5
        // gap is at least ceiling(875/4)=218
        // so need 875/218+1 = 5 buckets
        
        if(nums.length<2)   return 0;
        //if(nums.length==2)   return Math.abs(nums[1]-nums[0]);
        
        // n step to find max and min
        // n step to divide
        // n step to go through all bucket
        // only need to record the max and min in each bucket
        
        // find max and min
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i:nums){
            if(i>max)   max = i;
            if(i<min)   min = i;
        }
        
        int biggestLen = max-min;
        int minGap = (int) Math.ceil( ((double)biggestLen) / (nums.length-1) );
        int numBucket = (int) Math.ceil( ((double)biggestLen) / minGap)+1;      // 要+1  不然edge case會掛
        
        // n step to divide
        int [] minB = new int [numBucket];
        int [] maxB = new int [numBucket];
        for(int i:nums){
            int ind = (i-min)/minGap;
            if(maxB[ind]==0 && minB[ind]==0){
            	maxB[ind]=i;
            	minB[ind]=i;
            }
            
            if(i>maxB[ind]) maxB[ind]=i;
            if(i<minB[ind]) minB[ind]=i;
        }
        
        // n step to go through all bucket
        int maxGap = 0;
        int preMax =0;
        for(int i=0;i<minB.length;i++){
            if(minB[i]==0 && maxB[i]==0)    continue; // empty bucket
            if(minB[i]!=0 && preMax!=0){
                int currGap = minB[i] - preMax;
                maxGap = maxGap>currGap ? maxGap : currGap;
            }
            if(maxB[i]!=0){
                preMax = maxB[i];
            }else if(minB[i]!=0){
                preMax = minB[i];
            }
        }
        return maxGap;
    }
}