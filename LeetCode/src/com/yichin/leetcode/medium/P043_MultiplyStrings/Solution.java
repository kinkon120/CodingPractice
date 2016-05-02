package com.yichin.leetcode.medium.P043_MultiplyStrings;
/*
Given two numbers represented as strings, return multiplication of the numbers as a string.

Note: The numbers can be arbitrarily large and are non-negative.
*/
public class Solution {
    public String multiply(String num1, String num2) { 
        // 小數點嗎? no
        // 用寫紙上的算術做就好
    	// 9999*999 = 9989001 4位*3位=7位
        // 不用考慮非數字
        // https://leetcode.com/discuss/71593/easiest-java-solution-with-graph-explanation
        //  123
        // x456
        //--------
        //   18
        //  12
        //  6

        // 7ms
        int p = num1.length();
        int q = num2.length();
        
        char [] n1 = num1.toCharArray();
        char [] n2 = num2.toCharArray();
        
        int [] nums = new int [p+q];        
        for(int i=p-1; i>=0; i--){  
        	int carry=0;
            int pos=i+q; // 第一個index要是p+q-1, 從最右邊開始填
            
            for(int j=q-1; j>=0; j--){
                int sum = (n1[i]-'0')*(n2[j]-'0') + carry + nums[pos];
                nums[pos--] = sum%10;
                carry = sum/10;
            }
            // 多出來的一位
            nums[pos]=carry;
        }
        
        
        StringBuffer sb = new StringBuffer();
        // 注意一開始的一長串0
        for(int k : nums){
            if(!(sb.length() == 0 && k == 0)) sb.append(k);
        }
        // 要考慮 extreme case...
        return sb.length() == 0 ? "0" : sb.toString();
    }
}