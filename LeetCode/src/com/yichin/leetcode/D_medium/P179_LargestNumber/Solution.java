package com.yichin.leetcode.D_medium.P179_LargestNumber;
/*
Given a list of non negative integers, arrange them such that they form the largest number.

For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.
*/
public class Solution {
    public String largestNumber(int[] nums) {
        // https://leetcode.com/discuss/23422/my-java-solution-to-share
        // override comparator
        // 利用Arrays.sort(XXX, comparator)
        
        // 針對每個數字做排序?
        // 9,5,34,3,30
        // 最後再加總
        
        // bubble sort...
        for(int i=0;i<nums.length-1;i++){
            for(int j=0; j<nums.length-1;j++){
                if(!isBigger(nums[j], nums[j+1])){
                    // XOR swap
                    nums[j]^=nums[j+1];
                    nums[j+1]^=nums[j];
                    nums[j]^=nums[j+1];
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int n : nums){
            if(sb.length()==0 && n==0)    continue; // avoid preceding 0
            sb.append(n);
        }
        if(sb.length()==0) return "0";  // edge case
        
        return sb.toString();
    }
    
    
    // return true is n1 is "larger". Ex: 9 > 34
    boolean isBigger(int n1, int n2){
        String s1 = ""+n1+n2;   //934
        String s2 = ""+n2+n1;   //349
        
        return s1.compareTo(s2)>0;  // String.compare()回傳的是數字...
    }
}
