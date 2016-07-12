package com.yichin.leetcode.array.P011_ContainerWithMostWater;
/*
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
Find two lines, which together with x-axis forms a container, such that the container contains the most water.

要注意兩條柱子中間的其他柱子不會影響儲水量

Note: You may not slant the container.
*/

public class Solution {
    public int maxArea(int[] height) {
        // 只記得有O(n)的方法
        // https://leetcode.com/discuss/59635/easy-concise-java-o-n-solution-with-proof-and-explanation
        // 主要要會解釋left跟right移位的邏輯
        
        int maxArea=0;
        int left=0;
        int right=height.length-1;
        while(left < right){
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right-left));
            
            
            if(height[left] > height[right]){
            	// 此時right 指標往右移  才有機會造成比較大的高度
                right--;
            }else{
                left++;
            }
        }

        
        return maxArea;
    }
}