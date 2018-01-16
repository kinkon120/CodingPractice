package com.yichin.leetcode.D_medium.P241_DifferentWaysToAddParentheses;
/*
Given a string of numbers and operators, 
return all possible results from computing all the different possible ways to group numbers and operators. 
The valid operators are +, - and *.

Example 1
Input: "2-1-1".

((2-1)-1) = 0
(2-(1-1)) = 2
Output: [0, 2]


Example 2
Input: "2*3-4*5"

(2*(3-(4*5))) = -34
((2*3)-(4*5)) = -14
((2*(3-4))*5) = -10
(2*((3-4)*5)) = -10
(((2*3)-4)*5) = 10
Output: [-34, -14, -10, -10, 10]


*/

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        // https://discuss.leetcode.com/topic/19901/a-recursive-java-solution-284-ms
        // recursive的概念
        
        List<Integer> result = new ArrayList<Integer>();
        int size = input.length();
        for(int i=0; i< size; i++){
            char c = input.charAt(i);
            if(c=='+' || c=='-' || c=='*'){
                String p1 = input.substring(0,i);
                String p2 = input.substring(i+1);
                List<Integer> r1 = diffWaysToCompute(p1);
                List<Integer> r2 = diffWaysToCompute(p2);
                
                for(int i1 : r1){
                    for(int i2 : r2){
                        if(c=='+')  result.add(i1+i2);
                        else if(c=='-') result.add(i1-i2);
                        else result.add(i1*i2);
                    }
                }
            }
        }

        // 代表沒有+-*的符號
        if (result.size() == 0) {
            result.add(Integer.valueOf(input));
        }
        
        return result;
    }
}