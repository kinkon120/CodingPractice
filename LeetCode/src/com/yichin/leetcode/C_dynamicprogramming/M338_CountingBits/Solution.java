package com.yichin.leetcode.C_dynamicprogramming.M338_CountingBits;
/*
Given a non negative integer number num. 
For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

Example:
For num = 5 you should return [0,1,1,2,1,2].

Follow up:

It is very easy to come up with a solution with run time O(n*sizeof(integer)). 
But can you do it in linear time O(n) /possibly in a single pass? Space complexity should be O(n).
Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
Show Hint 

*/

public class Solution {
    public int[] countBits(int num) {
        // https://leetcode.com/discuss/92609/three-line-java-solution
        // 超帥解法
        
        // 用範例解的話
        /* 0 -> 0000
           1 -> 0001
           2 -> 0010
           3 -> 0011
           4 -> 0100
           5 -> 0101
           
           走到4的話  做right shift, 知道2總共會有1個bit, 另外4%2=0, 所以4會有1個bit
           走到5的話  做right shift, 知道2總共會有1個bit, 另外5%2=1, 所以5會有1個bit
        */
        
        int [] n = new int [num+1];
        // n[0]為0是預設值;
        for(int i=1;i<=num;i++){
            n[i]= n[i/2] + (i%2);
        }
        return n;
    }
}