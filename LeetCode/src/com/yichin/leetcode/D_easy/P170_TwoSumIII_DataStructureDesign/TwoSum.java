package com.yichin.leetcode.D_easy.P170_TwoSumIII_DataStructureDesign;

import java.util.HashMap;
import java.util.Map;

/*
Design and implement a TwoSum class. It should support the following operations: add and find.

add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.

For example,
add(1); add(3); add(5);
find(4) -> true
find(7) -> false
*/
public class TwoSum {
    // https://leetcode.com/discuss/76146/trade-off-in-this-problem-should-be-considered
    // 要考慮add跟find哪個會被call比較多次
    // 要考慮同一數字出現兩次的狀況
    
    // 一樣超時...耍我喔  靠
    Map <Integer, Integer> map;
    public TwoSum(){
        map = new HashMap<Integer, Integer>();
    }
    
	public void add(int number) {
        if(map.keySet().contains(number)){
            map.put(number,2);
        }else{
            map.put(number,1);
        }
	}

	public boolean find(int value) {
	    for(int k : map.keySet()){
	        int diff = value-k;
	        if(diff==k && map.get(diff)==2){
	            return true;
	        }else if(map.keySet().contains(diff)){
	            return true;
	        }
	    }
	    return false;
	}

    
    // add 比較多的狀況
    // 會超時
    // 理論上是可行的 跟HashMap比較一下
    /*
    Set<Integer> nums;
    Set<Integer> nums2;	// 存重複的數字

    public TwoSum(){
        nums = new HashSet<Integer>();
        nums2 = new HashSet<Integer>();
    }
    
	public void add(int number) {
	    if(!nums.add(number)){
	        nums2.add(number);
	    }
	}

	public boolean find(int value) {
	    for(int k : nums){
	        int diff = value - k;
	        if(diff == k){	// 代表value = k*2, 只有k出現兩次的狀況才可能
	            return nums2.contains(k);
	        }else{	// 正常狀況
	            if(nums.contains(diff)) return true;
	        }
	    }
	    return false;
	}
	*/
    

    // find會被call比較多次的狀況
    // Time Limit Exceeded, 但放到eclipse可以跑!
    /*
    Set<Integer> sums;
    Set<Integer> nums;
    public TwoSum(){
        sums = new HashSet<Integer>();
        nums = new HashSet<Integer>();
    }
    
    // Add the number to an internal data structure.
	public void add(int number) {
	    if(nums.contains(number)){
	        sums.add(number*2);
	    }else{
	        for(int k:nums){
	            sums.add(k+number);
	        }
	        nums.add(number);
	    }
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    return sums.contains(value);
	}
	*/
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);
