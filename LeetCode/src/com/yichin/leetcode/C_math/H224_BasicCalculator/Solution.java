package com.yichin.leetcode.C_math.H224_BasicCalculator;

import java.util.Stack;

/*
Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

You may assume that the given expression is always valid.

Some examples:
"1 + 1" = 2
" 2-1 + 2 " = 3
"(1+(4+5+2)-3)+(6+8)" = 23
Note: Do not use the eval built-in library function.
*/
public class Solution {
    public int calculate(String s) {
        // stack解
        // 沒有乘除號
        // https://discuss.leetcode.com/topic/15816/iterative-java-solution-with-stack/2
        // (1+(4+5+2)-3)+(6+8) = 23
        // stack要怎麼塞?
        // https://discuss.leetcode.com/topic/33044/java-easy-version-to-understand
        // sign用1 or -1表示, 可以塞進stack一起處理
        
        Stack<Integer> stack = new Stack<Integer>();
        int result=0;
        int sign=1;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){ // 要會用這個函數....
    			int sum = s.charAt(i) - '0';
    			while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) { // 條件很重要, 不能越界
    				sum = sum * 10 + s.charAt(i + 1) - '0';
    				i++;
    			}
    			result += sum * sign;
            }else if(c == '+'){
                sign=1;
            }else if(c == '-'){
                sign=-1;
            }else if(c =='('){
                stack.push(result); // 把括號前的暫存結果放進去
                stack.push(sign);   // '('前面的sign要記錄下來, 以便遇到')'時回頭處理
                result = 0; //要reset, 此時result要存的是括號內的結果
                sign=1; // 處理第一個數字預設都是正號
            }else if(c==')'){
                result = result*stack.pop() + stack.pop();
                // 第一部分的result*stack.pop()代表的是括號內的值
                // 第二部分的stack.pop()代表的是進入括號之前的值
            }
        }
        return result;
    }
}