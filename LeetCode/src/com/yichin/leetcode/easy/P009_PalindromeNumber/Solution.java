package com.yichin.leetcode.easy.P009_PalindromeNumber;
/*
Determine whether an integer is a palindrome. Do this without extra space.

click to show spoilers.

Some hints:
Could negative integers be palindromes? (ie, -1)

If you are thinking of converting the integer to string, note the restriction of using extra space.

You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?

There is a more generic way of solving this problem.
*/


public class Solution {
    public boolean isPalindrome(int x) {
        // https://leetcode.com/discuss/26665/o-1-space-o-lgn-time-java-solution-no-overflow-risk
        // negative
        if(x<0) return false;
        
        int p=x;
        int q=0;
        
        // x為 abcdefg
        // 目標是把p變成a, q變成gfedcb
        while(p>=10){
            q *= 10;
            q += (p%10);
            p /=10;
        }
        
        // 等於預留一位  保證此時q絕對不會overflow
        return p==x%10 && q==x/10;  //true when gfedcba = abcdefg, 避開了gfedcba可能會overflow的狀況
        
    }
}