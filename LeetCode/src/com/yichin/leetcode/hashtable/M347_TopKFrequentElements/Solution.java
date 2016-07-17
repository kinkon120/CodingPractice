package com.yichin.leetcode.hashtable.M347_TopKFrequentElements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        // http://www.programcreek.com/2014/05/leetcode-top-k-frequent-elements-java/
        // bucket sort: O(n)
        
        // count frequency for each num
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num : nums){    
            if(map.containsKey(num)){   // 不是contains
                map.put(num,map.get(num)+1);
            }else{
                map.put(num,1);
            }
        }
        
        // get max frequency
        int max = 0;
        for(int f : map.values()){    // 不是valueSet()
            max = Math.max(max, f);
        }
        
        // generate an array of list, index is frequency. Each list (fre[i]) stores numbers appear exactly "i" times
        // 宣告方式很重要!!
        ArrayList<Integer> [] freq = (ArrayList<Integer>[]) new ArrayList [max+1];

        for(int i=1; i<=max; i++){
            freq[i] = new ArrayList<Integer>();
        }
        for(Map.Entry<Integer, Integer> e : map.entrySet()){ // 宣告方式超重要~~
            int f = e.getValue();
            freq[f].add(e.getKey());
        }
        
        List<Integer> result = new ArrayList<Integer>();
        // count the first k 
        for(int i=max; i>=0; i--){
            List<Integer> cur = freq[i];
            if(cur.size()!=0){
                for(int n : cur){
                    result.add(n);
                    k--;
                    if(k==0)    return result;
                }
            }
        }
        // shouldn't reach here
        return null;
    }
}