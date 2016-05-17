package com.yichin.leetcode.medium.P137_SingleNumberII;

/*
Given an array of integers, every element appears three times except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/

public class Solution {
    public int singleNumber(int[] nums) {
        
        // https://leetcode.com/discuss/857/constant-space-solution
        // 用一個new int [32]來記錄每一個bit出現的次數
        // 10ms
        int [] freq = new int [32];
        int result = 0;
        
        for(int i=0;i<32;i++){
            for(int n : nums){
                if( ((n>>i)&1) ==1 ) freq[i]++; //注意優先權...擔心就用擴號包起來比較安全
            }
            result = result + (freq[i]%3) * (1<<i);
        }
        return result;
        
        // naive solution: hashMap
        // 16 ms
        /*
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num : nums){
            if(map.get(num)==null){
                map.put(num, 1);
            }else{
                int count = map.get(num);
                map.put(num, count+1);
            }
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){    // 這個語法很奇怪...不能只用Entry宣告
            if(entry.getValue()!=3)   return entry.getKey();
        }
        return 0;
        */
    }
}