package com.yichin.leetcode.C_hashtable.M049_GroupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:
For the return value, each inner list's elements must follow the lexicographic order.
All inputs will be in lower-case.
*/

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        
        List<List<String>> ans = new ArrayList<>();
        if(strs==null || strs.length==0)    return ans;
        
        HashMap<String, List<String>> hm = new HashMap<>();

        for(int i=0; i<strs.length; i++){
            String sortedStr = sortString(strs[i]);
            if(hm.get(sortedStr) != null){
                hm.get(sortedStr).add(strs[i]);
            }else{
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                hm.put(sortedStr, list); // 用sortedStr當key, 不是strs[i]
            }
        }
        
        for(List<String> list : hm.values()){
            Collections.sort(list);
            ans.add(list);
        }
        
        return ans;    
    }

    String sortString(String s){
        if(s==null || s.length()==0) return s;
        
        char [] cs = s.toCharArray();
        Arrays.sort(cs);
        return new String(cs);
    }
}