package com.yichin.leetcode.math.E202_HappyNumber;
/*
Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, 
replace the number by the sum of the squares of its digits, 
and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 0^2 = 1
*/

public class Solution {
    public boolean isHappy(int n) {
        // use slow/fast trick
        // 2ms, space O(1)
        int slow = n;
        int fast = n;
        while(true){
            slow = cal(slow);
            fast = cal(cal(fast));
            
            if(fast==1) return true;
            if(slow==fast) return false; //found cyclic
        }

        // 5 ms
        // space is not O(1)
        /*
        Set<Integer> set = new HashSet<Integer>();  // check cycle
        while(n!=1){
            int tmp=0;
            while(n!=0){
                int dig = n%10;
                n/=10;
                tmp += dig*dig;
            }
            
            if(!set.add(tmp)) return false; // found cycle
            n=tmp;
        }
        return true;
        */
    }
    
    int cal(int n){
        int result=0;
        while(n!=0){
            int dig = n%10;
            n/=10;
            result += dig*dig;
        }
        return result;
    }
}