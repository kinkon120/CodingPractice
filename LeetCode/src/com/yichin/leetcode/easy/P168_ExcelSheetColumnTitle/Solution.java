package com.yichin.leetcode.easy.P168_ExcelSheetColumnTitle;
/*
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB
*/
public class Solution {
    public String convertToTitle(int n) {
        // https://leetcode.com/discuss/19047/my-1-lines-code-in-java-c-and-python
        
        if(n==0) return "";
        return convertToTitle((n-1)/26) + (char)((n-1)%26+'A'); 
        // 不能用n, 要用n-1...
        // 拿26做極端例子
    }
}