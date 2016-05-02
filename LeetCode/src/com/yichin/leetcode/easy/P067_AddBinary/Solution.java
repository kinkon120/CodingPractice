package com.yichin.leetcode.easy.P067_AddBinary;
/*
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
*/
public class Solution {
    public String addBinary(String a, String b) {
        
        //我的解法OK
        if(a==null || a.length()==0)    return b;
        if(b==null || b.length()==0)    return a;
        
        int len = a.length() > b.length() ? a.length() : b.length(); // 取大的
        a = new StringBuilder(a).reverse().toString();	// 這個用法可以記下來...
        b = new StringBuilder(b).reverse().toString();
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<len;i++){
            int ai=0;
            int bi=0;
            if(i<a.length())    ai=a.charAt(i)-'0';
            if(i<b.length())    bi=b.charAt(i)-'0';
            int sum = ai+bi+carry;
            sb.append(sum%2);
            carry = sum/2;
        }
        
        if(carry == 1) sb.append(1);
        return sb.reverse().toString();
        
        // https://leetcode.com/discuss/16267/simple-accepted-java-solution
        // 可以參考他怎麼從後面讀的 while(i>-1 || j>-1) --> 只要還有剩下的就繼續做
    }
}