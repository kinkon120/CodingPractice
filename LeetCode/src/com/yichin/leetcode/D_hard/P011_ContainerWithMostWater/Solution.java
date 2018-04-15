package com.yichin.leetcode.D_hard.P011_ContainerWithMostWater;
/*
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
n vertical lines are drawn such that the two end points of line i is at (i, ai) and (i, 0). 
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
            	// 左邊比較高，代表右邊柱子要往左移找更高的柱子
                right--;
            }else{
                left++;
            }
        }
        return maxArea;
    }
}
