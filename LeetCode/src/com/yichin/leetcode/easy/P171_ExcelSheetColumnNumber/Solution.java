package com.yichin.leetcode.easy.P171_ExcelSheetColumnNumber;
/*
Related to question Excel Sheet Column Title

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
*/

public class Solution {
    public int titleToNumber(String s) {
    	// 3ms
        if(s==null || s.length()==0)    return 0;
        char [] sc = s.toCharArray();
        // 26進位制
        int k=0;
        for(int i=0;i<sc.length;i++){
            k*=26;
            int d = sc[i] - 'A' + 1;
            k+=d;
        }
        return k;
        
        //可以用更漂亮的表示法
        /*
         * for(char c : s.toCharArray()){
         * 	k= k*26 + (c - 'A' +1);
         * }
         * */
    }
}