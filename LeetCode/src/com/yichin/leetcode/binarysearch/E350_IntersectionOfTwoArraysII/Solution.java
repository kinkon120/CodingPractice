package com.yichin.leetcode.binarysearch.E350_IntersectionOfTwoArraysII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:
Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:
What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
*/
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // 只是找交集  不是要找連續的range...
        // https://leetcode.com/discuss/103835/ac-solution-using-java-hashmap
        // 直接用hashMap count每個數字發生的頻率即可
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int n:nums1){
            if(map.containsKey(n))  map.put(n, map.get(n)+1);
            else map.put(n,1);
        }
        
        Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();
        for(int n:nums2){
            if(map2.containsKey(n))  map2.put(n, map2.get(n)+1);
            else map2.put(n,1);
        }
        
        List<Integer> list = new ArrayList<Integer>();
        // find intersection
        for(int n : map.keySet()){  // 不是KeySet()
            if(map2.containsKey(n)){
                int f1=map.get(n);
                int f2=map2.get(n);
                int len = f1>f2 ? f2 : f1;  // get min one
                for(int i=0;i<len;i++){
                    list.add(n);
                }
            }
        }
        
        int [] ret = new int [list.size()];
        for(int i=0;i<list.size(); i++){
            ret[i]=list.get(i);
        }
        
        return ret;
        
    }
}