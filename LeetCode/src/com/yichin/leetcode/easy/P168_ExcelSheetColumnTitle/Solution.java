package com.yichin.leetcode.easy.P168_ExcelSheetColumnTitle;
/*
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA --> 26*1 + 1
    28 -> AB
    AAA 反推回去 --> 26^2*1 + 26^1*1 + 26^0*1
   	CBA 反推回去 --> 26^2*3 + 26^2*1 + 26^0*1
   	C對應到3的算法是'C'-'A'+1
   	Z對應到26的算法是'Z'-'A'+1
   	要解釋offset的issue
   	
   	現在給你57
   	57%26=5 -> 'A'+(5-1)= 'E'
   	57/26=2
   	2%26=2  -> 'A'+(2-1)= 'B'
    2/26=0	over
    
	ZA是 26*26 + 1 = 677
	(677-1)%26 = 0 -> 得到 'A'
	677/26 = 26, 26-1 =25 -> 得到'Z'

*/
public class Solution {
    public String convertToTitle(int n) {
        // https://leetcode.com/discuss/19047/my-1-lines-code-in-java-c-and-python
        
        if(n==0) return "";
        return convertToTitle((n-1)/26) + (char)((n-1)%26+'A'); 
        // 不能用n, 要用n-1...
        // 拿26做極端例子
        
        /*  用do while做，不能用while, 不然1->'A'的case會沒法處理
        StringBuilder sb = new StringBuilder();
        do{
            n--;
            int k = n%26;
            sb.insert(0, (char) (k+'A'));
            n/=26;
        }while(n != 0);
        
        return sb.toString();
        */
        
    }
}