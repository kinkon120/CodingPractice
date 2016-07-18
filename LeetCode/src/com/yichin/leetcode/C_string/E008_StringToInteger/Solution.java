package com.yichin.leetcode.C_string.E008_StringToInteger;
/*
Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

Requirements for atoi:
The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.


*/

public class Solution {
    public int myAtoi(String str) {
        // 要考慮所有的case...
        // 忽略空白
        // 負號
        // 0開頭
        // overflow
        
        // skip whitespace
        str = str.trim();
        
        // edge case
        if(str.length()==0) return 0;
        
        boolean isNegative = false;
        char c0 = str.charAt(0);
        
        // if the first char is not valid...
        if( !(c0=='-' || c0=='+' || (c0>='0' && c0<='9'))) return 0;
        
        if(c0=='-')  isNegative = true;
        if(c0=='-' || c0=='+')    str = str.substring(1); // skip the sign
        
        long result=0;	// for overflow purpose
        char [] cs = str.toCharArray();
        for(char ch : cs){
            if(ch >= '0' && ch<='9'){
                result = result*10;
                result += ch-'0';
                
                // 只要一超過就不用再往下做啦
                if( result > Integer.MAX_VALUE && isNegative==false) return Integer.MAX_VALUE;
                if( result*(-1) < Integer.MIN_VALUE && isNegative==true) return Integer.MIN_VALUE;
            }else{
                break;
            }
        }
        
        if(isNegative)  result *= -1;
        return (int) result;
    }
}