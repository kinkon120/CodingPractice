package com.yichin.leetcode.medium.P229_MajorityElementII;

import java.util.ArrayList;
import java.util.List;

/*
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.
*/
public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // 不能預先sort...
        // 紀錄目前最大的兩個數字
        // 如果剛好有三個數字都不同...那三個數字都上不了榜, 因為根據定義要"超過", 而不是大於等於, 根據條件要出現>=2次才算...
        
    	// https://leetcode.com/discuss/69126/concise-java-solution-based-on-moores-voting-algorithm
    	// Moore's Voting Algorithm
    	// 一定要提到這個
    	
        List<Integer> result = new ArrayList<>();
        
        // edge case
        if(nums == null || nums.length==0)  return result;
        int c1=0, c2=0;
        int n1=0, n2=0;   // doesn't matter
        int len= nums.length;
        
        for(int i=0;i<len;i++){
            if(nums[i]==n1){
                c1++;
            }else if(nums[i]==n2){
                c2++;
            }else if(c1==0){
                n1=nums[i];
                c1=1;
            }else if(c2==0){
                n2=nums[i];
                c2=1;
            }else{
            	// 要解釋why兩個都要減1
                c1--;
                c2--;
            }
        }
        
        c1=0;
        c2=0;
        // count again
        for(int i=0; i<len;i++){
            if(nums[i]==n1) c1++;
            else if(nums[i]==n2) c2++;  // 不能用單純if...不然n1=n2的時候會重複計算
        }
        
        if(c1 > len/3) result.add(n1);
        if(c2 > len/3) result.add(n2);
        
        return result;
    }
}