package com.yichin.leetcode.C_twopointer.E349_IntersectionOfTwoArrays;

import java.util.HashSet;
import java.util.Set;

/*
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
Each element in the result must be unique. 不能重複啦  靠背
The result can be in any order.
*/
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // edge cases?
        
        Set<Integer> s1 = new HashSet<Integer>();
        Set<Integer> intersect = new HashSet<Integer>();
        
        for(int n:nums1){
            s1.add(n);
        }
        
        for(int n:nums2){
            if(s1.contains(n)){
                intersect.add(n);
            }
        }        
        
        int [] result = new int [intersect.size()];
        int i =0;
        for(int n: intersect){
            result[i++] = n;
        }
        return result;
    }
}
