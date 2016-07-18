package com.yichin.leetcode.D_hard.P042_TrappingRainWater;
/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. 
In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
*/

public class Solution {
    public int trap(int[] height) {
        // 有O(n)解法喔...
        // https://leetcode.com/discuss/10046/share-my-short-solution
        // 記得左邊最高跟右邊最高的高度兩個數字
        int s = 0;
        int e = height.length-1;
        int max = 0;
        int rMaxH = 0;
        int lMaxH = 0;
        
        while(s<e){    // 解答是用<=, 我覺得用<就可以了, 因為s,e重合的時候, 不能夠重新計算的
            rMaxH = Math.max(rMaxH, height[e]);
            lMaxH = Math.max(lMaxH, height[s]);
            if(rMaxH >= lMaxH){
                // 右邊比較大, 左邊要找更大的
                max += (lMaxH - height[s]);   // lMaxH is smaller than rMaxH, so the (lMaxH-height[s]) water can be stored
                // 用+=最好配上括號
                s++;
            }else{
                max += (rMaxH - height[e]);
                e--;
            }
        }
        return max;
    }
}