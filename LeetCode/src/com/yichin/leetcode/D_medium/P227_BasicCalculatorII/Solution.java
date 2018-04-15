package com.yichin.leetcode.D_medium.P227_BasicCalculatorII;

import java.util.Stack;

/*
Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

You may assume that the given expression is always valid.

Some examples:
"3+2*2" = 7
" 3/2 " = 1
" 3+5 / 2 " = 5
*/

public class Solution {
    public int calculate(String s) {
        // https://leetcode.com/discuss/41902/share-my-java-solution
        // use a stack to save all integers
        // use an example to illustrate: 8+7/2-3*6/2=8+3+9=20
        
        s = s.replaceAll("\\s","");
        Stack<Integer> stack = new Stack<Integer>();
        char sign = '+';
        int num = 0;
        for(int i=0; i< s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                num = num*10 + s.charAt(i)-'0';
            }
            
            if(!Character.isDigit(s.charAt(i)) || i==s.length()-1){
                // sign is the previous sign, 用預存的operator計算
                if(sign=='+'){
                    stack.push(num);
                }else if(sign =='-'){
                    stack.push(-num);   // 高招!
                }else if(sign =='*'){
                    stack.push(stack.pop()*num);
                }else if(sign =='/'){
                    stack.push(stack.pop()/num);
                }
                
                // update sign
                sign = s.charAt(i);
                num=0;
            }
        }
        int ret = 0;
        while(!stack.isEmpty()){
            ret += stack.pop();
        }
        return ret;
    }
}
