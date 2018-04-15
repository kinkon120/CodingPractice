package com.yichin.leetcode.D_medium.P089_GrayCode;

import java.util.ArrayList;
import java.util.List;

/*
The gray code is a binary numeral system where two successive values differ in only one bit.
Given a non-negative integer n representing the total number of bits in the code, 
print the sequence of gray code. A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2

Note:
For a given n, a gray code sequence is not uniquely defined.

For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
*/
public class Solution {
    public List<Integer> grayCode(int n) {
        // 觀察如下 0 1 3 2之後, 會是0 1 3 2 6 7 5 4
        // 6 7 5 4可以從reverse 0 1 3 2 --> 2 3 1 0, 全部+4
        // 2ms
        // 我的解法跟這個討論串很像 https://leetcode.com/discuss/2978/what-solution-gray-code-problem-extra-space-used-recursion
    	// 用LinkedList反而會比ArrayList performance差, 會變成4ms?
         
        List<Integer> result = new ArrayList<Integer>();
        
        // base case;
        result.add(0);
        if(n==0) return result;
        // 可省略掉n=1的狀況, while也可以handle

        int k=1;
        while(k<=n){
            int pad= 1<<(k-1);
            List<Integer> tail = new ArrayList<Integer>();
            for(int i=result.size()-1;i>=0;i--){
                tail.add(result.get(i)+pad);
            }
            result.addAll(tail);
            k++;
        }
        return result;
    }
}
